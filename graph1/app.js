// set up SVG for D3
//const fs = require("fs");

var width  = 1375,
    height = 493,
    colors = d3.scale.category10();

var svg = d3.select('body')
  .append('svg')
  .attr('oncontextmenu', 'return false;')
  .attr('width', width)
  .attr('height', height);



// set up initial nodes and links
//  - nodes are known by 'id', not by index in array.
//  - reflexive edges are indicated on the node (as a bold black circle).
//  - links are always source < target; edge directions are set by 'left' and 'right'.
var nodes = [
  ],
  lastNodeId = 0,
  lastNodebuf = 0,
  links = [
  ];

var kernel1=[
];
var ids= null;
// init D3 force layout
var force = d3.layout.force()
    .nodes(nodes)
    .links(links)
    .size([width, height])
    .linkDistance(150)
    .charge(-500)
    .on('tick', tick)

// define arrow markers for graph links
svg.append('svg:defs').append('svg:marker')
    .attr('id', 'end-arrow')
    .attr('viewBox', '0 -5 10 10')
    .attr('refX', 6)
    .attr('markerWidth', 3)
    .attr('markerHeight', 3)
    .attr('orient', 'auto')
  .append('svg:path')
    .attr('d', 'M0,-5L10,0L0,5')
    .attr('fill', '#000');

svg.append('svg:defs').append('svg:marker')
    .attr('id', 'start-arrow')
    .attr('viewBox', '0 -5 10 10')
    .attr('refX', 4)
    .attr('markerWidth', 3)
    .attr('markerHeight', 3)
    .attr('orient', 'auto')
  .append('svg:path')
    .attr('d', 'M10,-5L0,0L10,5')
    .attr('fill', '#000');

// line displayed when dragging new nodes
var drag_line = svg.append('svg:path')
  .attr('class', 'link dragline hidden')
  .attr('d', 'M0,0L0,0');

// handles to link and node element groups
var path = svg.append('svg:g').selectAll('path'),
    circle = svg.append('svg:g').selectAll('g');

// mouse event vars
var selected_node = null,
    selected_link = null,
    mousedown_link = null,
    mousedown_node = null,
    mouseup_node = null;

function resetMouseVars() {
  mousedown_node = null;
  mouseup_node = null;
  mousedown_link = null;
}

var ker = 1;
function kernel(){
   ker = 1;
   upp =0;
   //alert("Kernel mode");
   document.getElementById('tablebody').innerHTML ="Kernel mode";
   document.getElementById('label1').innerHTML = null;
   document.getElementById('tablebody4').innerHTML = '';
   document.getElementById('tablebody5').innerHTML = '';
   document.getElementById('tablebody6').innerHTML = '';

}
function buffer(){
  ker = 0;
  upp = 0;
  //alert("buffer mode");
  document.getElementById('tablebody').innerHTML ="Buffer mode";
  document.getElementById('label1').innerHTML = null;
  document.getElementById('tablebody4').innerHTML = '';
  document.getElementById('tablebody5').innerHTML = '';
  document.getElementById('tablebody6').innerHTML = '';

}

var upp = 0;
function update(){
  upp = 1;
  //alert("uppdate mode");
  document.getElementById('tablebody').innerHTML ="update mode";
  document.getElementById('label1').innerHTML = null;
  document.getElementById('tablebody4').innerHTML = '';
  document.getElementById('tablebody5').innerHTML = '';
  document.getElementById('tablebody6').innerHTML = '';

}

// update force layout (called automatically each iteration)
function tick() {
  // draw directed edges with proper padding from node centers
  path.attr('d', function(d) {
    var deltaX = d.target.x - d.source.x,
        deltaY = d.target.y - d.source.y,
        dist = Math.sqrt(deltaX * deltaX + deltaY * deltaY),
        normX = deltaX / dist,
        normY = deltaY / dist,
        sourcePadding = d.left ? 17 : 12,
        targetPadding = d.right ? 17 : 12,
        sourceX = d.source.x + (sourcePadding * normX),
        sourceY = d.source.y + (sourcePadding * normY),
        targetX = d.target.x - (targetPadding * normX),
        targetY = d.target.y - (targetPadding * normY);
    return 'M' + sourceX + ',' + sourceY + 'L' + targetX + ',' + targetY;
  });

  circle.attr('transform', function(d) {
    return 'translate(' + d.x + ',' + d.y + ')';
  });
}

// update graph (called when needed)
function restart() {
  // path (link) group
  path = path.data(links);

  // update existing links
  path.classed('selected', function(d) { return d === selected_link; })
    .style('marker-start', function(d) { return d.left ? 'url(#start-arrow)' : ''; })
    .style('marker-end', function(d) { return d.right ? 'url(#end-arrow)' : ''; });


  // add new links
  path.enter().append('svg:path')
    .attr('class', 'link')
    .classed('selected', function(d) { return d === selected_link; })
    .style('marker-start', function(d) { return d.left ? 'url(#start-arrow)' : ''; })
    .style('marker-end', function(d) { return d.right ? 'url(#end-arrow)' : ''; })
    .on('mousedown', function(d) {
      if(d3.event.ctrlKey) return;

      // select link
      mousedown_link = d;
      if(mousedown_link === selected_link) selected_link = null;
      else selected_link = mousedown_link;
      selected_node = null;
      restart();
    });

  // remove old links
  path.exit().remove();


  // circle (node) group
  // NB: the function arg is crucial here! nodes are known by id, not by index!
  circle = circle.data(nodes, function(d) { return d.id; });

  // update existing nodes (reflexive & selected visual states)
  circle.selectAll('circle')
    .style('fill', function(d) { return (d === selected_node) ? d3.rgb(colors(d.id)).brighter().toString() : colors(d.id); })
    .classed('reflexive', function(d) { return d.reflexive; });

  // add new nodes
  var g = circle.enter().append('svg:g');
  var pp =0;
  if(ker)
      pp =12;
  else
      pp = 20;
  g.append('svg:circle')
    .attr('class', 'node')
    .attr('r', pp)
    .style('fill', function(d) { return (d === selected_node) ? d3.rgb(colors(d.id)).brighter().toString() : colors(d.id); })
    .style('stroke', function(d) { return d3.rgb(colors(d.id)).darker().toString(); })
    .classed('reflexive', function(d) { return d.reflexive; })
    .on('mouseover', function(d) {
      if(!mousedown_node || d === mousedown_node) return;
      // enlarge target node
      d3.select(this).attr('transform', 'scale(1.1)');
    })
    .on('mouseout', function(d) {
      if(!mousedown_node || d === mousedown_node) return;
      // unenlarge target node
      d3.select(this).attr('transform', '');
    })
    .on('mousedown', function(d) {
      if(d3.event.ctrlKey) return;
      ids = d;
      // select node
      mousedown_node = d;
      if(mousedown_node === selected_node) selected_node = null;
      else selected_node = mousedown_node;
      selected_link = null;

      // reposition drag line
      drag_line
        .style('marker-end', 'url(#end-arrow)')
        .classed('hidden', false)
        .attr('d', 'M' + mousedown_node.x + ',' + mousedown_node.y + 'L' + mousedown_node.x + ',' + mousedown_node.y);

      restart();
    })
    .on('mouseup', function(d) {
      if(!mousedown_node) return;

      // needed by FF
      drag_line
        .classed('hidden', true)
        .style('marker-end', '');

      // check for drag-to-self
      mouseup_node = d;
      if(mouseup_node === mousedown_node) { resetMouseVars(); return; }

      // unenlarge target node
      d3.select(this).attr('transform', '');

      // add link to graph (update if exists)
      // NB: links are strictly source < target; arrows separately specified by booleans
      var source, target, direction;
      if(mousedown_node.id < mouseup_node.id) {
        source = mousedown_node;
        target = mouseup_node;
        direction = 'right';
      } else {
        source = mouseup_node;
        target = mousedown_node;
        direction = 'left';
      }

      var link;
      link = links.filter(function(l) {
        return (l.source === source && l.target === target);
      })[0];

      if(link) {
        link[direction] = true;
      } else {
        link = {source: source, target: target, left: false, right: false};
        link[direction] = true;
        links.push(link);
      }

      // select new link
      selected_link = link;
      selected_node = null;
      restart();
    });

  // show node IDs
  g.append('svg:text')
      .attr('x', 0)
      .attr('y', 4)
      .attr('class', 'id')
      .text(function(d) { return d.id; });

  // remove old nodes
  circle.exit().remove();

  // set the graph in motion
  force.start();
}

function mousedown() {
  // prevent I-bar on drag
  //d3.event.preventDefault();
  //if(lastNodebuf > 0) return 0;
  // because :active only works in WebKit?
  if ( upp != 1 ) {
  svg.classed('active', true);

  if(d3.event.ctrlKey || mousedown_node || mousedown_link) return;

  // insert new node at point
  var point = d3.mouse(this);
     if(ker)
      node = {id: "k" + lastNodeId++, reflexive: false};
      else
      node = {id: "B"+(lastNodebuf++), reflexive: false};
      node.x = point[0];
      node.y = point[1];
 // alert(ker);
  nodes.push(node);
 // fs.writeFile("fileName.txt", "mynameisvivek", function (err) {
   //   if (err) return console.log(err);
     //           });
  restart();
}
}


function mousemove() {
  if(!mousedown_node) return;

  // update drag line
  drag_line.attr('d', 'M' + mousedown_node.x + ',' + mousedown_node.y + 'L' + d3.mouse(this)[0] + ',' + d3.mouse(this)[1]);

  restart();
}

function mouseup() {
  if(mousedown_node) {
    // hide drag line
    drag_line
      .classed('hidden', true)
      .style('marker-end', '');
  }

  // because :active only works in WebKit?
  svg.classed('active', false);

  // clear mouse event vars
  resetMouseVars();
}

function spliceLinksForNode(node) {
  var toSplice = links.filter(function(l) {
    return (l.source === node || l.target === node);
  });
  toSplice.map(function(l) {
    links.splice(links.indexOf(l), 1);
  });
}

// only respond once per keydown
var lastKeyDown = -1;

function keydown() {
  //d3.event.preventDefault();
  if(lastKeyDown !== -1) return;
  lastKeyDown = d3.event.keyCode;

  // ctrl
  if(d3.event.keyCode === 17) {
    circle.call(force.drag);
    svg.classed('ctrl', true);
  }
  //alert(selected_node);
  if(!selected_node && !selected_link) return;
  switch(d3.event.keyCode) {
    //case 8: // backspace
    case 46: // delete
        if(selected_node) if(selected_node.id[0] == 'k')
                  lastNodeId--;
         else {
                  lastNodebuf--;

         }
      if(selected_node) {
        nodes.splice(nodes.indexOf(selected_node), 1);
        spliceLinksForNode(selected_node);
      } else if(selected_link) {
        links.splice(links.indexOf(selected_link), 1);
      }
      selected_link = null;
      selected_node = null;
      restart();
      break;
    case 66: // B
      if(selected_link) {
        // set link direction to both left and right
        selected_link.left = true;
        selected_link.right = true;
      }
      restart();
      break;
    case 76: // L
      if(selected_link) {
        // set link direction to left only
        selected_link.left = true;
        selected_link.right = false;
      }
      restart();
      break;
    case 82: // R
      if(selected_node) {
        // toggle node reflexivity
        selected_node.reflexive = !selected_node.reflexive;
      } else if(selected_link) {
        // set link direction to right only
        selected_link.left = false;
        selected_link.right = true;
      }
      restart();
      break;
  }
}

function keyup() {
  lastKeyDown = -1;

  // ctrl
  if(d3.event.keyCode === 17) {
    circle
      .on('mousedown.drag', null)
      .on('touchstart.drag', null);
    svg.classed('ctrl', false);
  }

}

function savejson(){

if(Object.keys(kernel1).length >= lastNodeId){
    filename = 'console.json'
    if(typeof nodes === "object"){
        lin = JSON.stringify(kernel1, undefined, 4)
    }

    var blob = new Blob([lin], {type: 'text/json'}),
        e    = document.createEvent('MouseEvents'),
        a    = document.createElement('a')

    a.download = filename
    a.href = window.URL.createObjectURL(blob)
    a.dataset.downloadurl =  ['text/json', a.download, a.href].join(':')
    e.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null)
    a.dispatchEvent(e)

//$(function(){$.getJSON('/home/vivek/Desktop/nowdownload/vivek.json',function(data){console.log('success');alert(data);}).error(function(){console.log('error');});});

 }
 else {
   alert("Some Kernels are left with undescriptive");
 }
 }

var kernel2;
function done(){
  var count = Object.keys(kernel1).length;
  //var i =0 ;
  //alert(ids.id);
  //alert(kernel1[0].id);
  //for(i=0;i< count;i++)
   //if(kernel1[i].id == ids.id)
   {
    var count1 = Object.keys(kernel2.input).length;
    //alert(kernel1[i].id+"1");
    kernel2.name =document.getElementById(kernel2.id+"1").value;
    kernel2.Workdimension=document.getElementById(kernel2.id+"2").value;
    kernel2.partition=document.getElementById(kernel2.id+"3").value;
    kernel2.src=document.getElementById(kernel2.id+"4").value;

    var j=0;
    for(j=0;j< count1;j++){
      kernel2.input[j].position = document.getElementById(kernel2.input[j].id+"1").value;
      kernel2.input[j].size = document.getElementById(kernel2.input[j].id+"2").value;
      //tableBody += '  <td><input  placeholder="type"     id='+links[i].target.id + flag++ +' type="text"></td>';
      kernel2.input[j].type = document.getElementById(kernel2.input[j].id+"3").value;

      kernel2.input[j].break = document.getElementById(kernel2.input[j].id+"4").value;
      kernel2.input[j].from = document.getElementById(kernel2.input[j].id+"5").value;
    }
    count1 = Object.keys(kernel2.out).length;
    //alert(count1);
    j=0;
    for(j=0;j< count1;j++){
      kernel2.out[j].position = document.getElementById(kernel2.out[j].id+"1").value;
      kernel2.out[j].size = document.getElementById(kernel2.out[j].id+"2").value;
      kernel2.out[j].type = document.getElementById(kernel2.out[j].id+"3").value;
      kernel2.out[j].break = document.getElementById(kernel2.out[j].id+"4").value;
      kernel2.out[j].from = document.getElementById(kernel2.out[j].id+"5").value;
    }
    var argumen ={position:null,size:null,break:null,from:null,type:null};
    var sid =0;
    for(j=0;j<document.getElementById('n1').value;j++)
      {
        argumen.position = document.getElementById(j + "0").value;
        argumen.size = document.getElementById(j + "1").value;
        argumen.type = document.getElementById(j + "2").value;
        argumen.break = document.getElementById(j + "3").value;
        argumen.from = document.getElementById(j + "4").value;

        kernel2.Arguments.push(argumen);
      }

      var io = {position:null,size:null,type:null};
      for(j=0;j<document.getElementById('n3').value;j++)
        {
          io.position = document.getElementById("n3"+j).value;
          io.size = document.getElementById("n31"+j).value;
          io.type = document.getElementById("n32"+j).value;
          kernel2.IObuffer.push(io);
        }
        var io1 = {position:null,size:null,type:null};
        for(j=0;j<document.getElementById('n2').value;j++)
          {
            io1.position = document.getElementById("n2"+j).value;
            io1.size = document.getElementById("n21"+j).value;
            io1.type = document.getElementById("n22"+j).value;
            kernel2.varArguments.push(io1);
          }


  }
  var i =0 ;
  var che =0;
  //alert(ids.id);
  //alert(kernel1[0].id);

  for(i=0;i<Object.keys(kernel1).length;i++)
   if(kernel1[i].id == kernel2.id)
{ kernel1.pop(kernel1[i].id)
  kernel1.push(kernel2);
  alert("already present");
  che = 1;
  break;
}
if(che == 0){
  kernel1.push(kernel2);
}
  alert(ids.id+" is Updated");
}
function description(){
  var i =0;
  var tableBody = '';
  var count  = 0;
  //alert(document.getElementById('n1').value);
   if(document.getElementById('n1').value != 0 && document.getElementById('n1').value){
     tableBody += '<tr>';
     tableBody += '<td> <h5 align="center"> Arguments</h5></td>';
     tableBody += '</tr>';
   }
    for(i=0;i<document.getElementById('n1').value;i++)
      {       count = 0;
              tableBody += '<tr>';
              tableBody += '  <td><input  placeholder="position " id='+i + count++ +' type="text"></td>';
              tableBody += '  <td><input  placeholder="size" id='+i + count++ +' type="text"></td>';
              tableBody += '  <td><input  placeholder="type" id='+i  + count++ +' type="text"></td>';
              tableBody += '  <td><input  placeholder="break" id='+i + count++ +' type="text"></td>';
              tableBody += '  <td><input  placeholder="from" id='+i + count++ +' type="text"></td>';
              tableBody += '</tr>';
      }
      if(document.getElementById('n2').value){
      tableBody += '<tr>';
      tableBody += '<td> <h5 align="center"> VarArguments</h5></td>';
      tableBody += '</tr>';
      }
      count = 0;
      for(i=0;i<document.getElementById('n2').value;i++)
        {
                tableBody += '<tr>';
                tableBody += '  <td><input  placeholder="position " id='+"n2" +i +' type="text"></td>';
                tableBody += '  <td><input  placeholder="size " id='+"n21" +i +' type="text"></td>';
                tableBody += '  <td><input  placeholder="type" id='+"n22" +i +' type="text"></td>';
                tableBody += '</tr>';
        }
   if(document.getElementById('n3').value){
        tableBody += '<tr>';
        tableBody += '<td> <h5 align="center"> IObuffer</h5></td>'
        tableBody += '</tr>';
      }
        count = 0;
      for(i=0;i<document.getElementById('n3').value;i++)
        {
                tableBody += '<tr>';
                tableBody += '  <td><input  placeholder="position " id='+"n3" + i +' type="text"></td>';
                tableBody += '  <td><input  placeholder="size " id='+"n31" + i +' type="text"></td>';
                tableBody += '  <td><input  placeholder="type" id='+"n32" + i +' type="text"></td>';
                tableBody += '</tr>';
        }



    var tableBo = '<input class="button-primary"  onclick="done()" value="update"  		id="final" type="button"/>';
    document.getElementById('tablebody6').innerHTML = tableBody;
    document.getElementById('tablebody7').innerHTML = tableBo;
    document.getElementById('label1').innerHTML = null;
}

function check2(){
  if(upp == 1 && ids.id[0] == 'k')
  {

  var tableBody = '';
  var depends = '[';
  var count = Object.keys(links).length;
  var i = 0;
  var flag = 0;
  var inputB =[];
  var outB =[];
  document.getElementById('tablebody').innerHTML =ids.id;
      tableBody += '<tr>';
      tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="kernel ID:- '+ids.id+'" id="ID" type="text" readonly></td>';
 for (i = 0; i < count; i++)
 if(ids.id[0] == 'k'){

      if(links[i].source.id == ids.id)
       if(links[i].target.id[0] == 'k')
         {if (flag == 1) depends+=',';
           depends+=links[i].target.id;
           if (flag == 0)flag = 1;
         }
      if(links[i].target.id == ids.id)
      if(links[i].source.id[0] == 'k')
      {if (flag == 1) depends+=',';
       depends+=links[i].source.id;
       if (flag == 0)flag = 1;
      }
    }
      depends+=']';
      flag = 0
      tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value='+depends+' id='+ids.id + flag++ +' type="text" readonly></td>';
      tableBody += '  <td><input  placeholder="Name" id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '  <td><input  placeholder="Workdimension" id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '  <td><input  placeholder="Partition" id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '  <td><input  placeholder="Src" id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '</tr>';
      flag = 0;
  for (i = 0; i < count; i++)
  if(ids.id[0] == 'k'){
       if(links[i].source.id == ids.id || links[i].target.id == ids.id)
           {
             if(links[i].source.id == ids.id)
                if(links[i].target.id[0] == 'B'){
                        {   //alert(links[i].target.id+flag);
                            flag = 0;
                            tableBody += '<tr>';
                            if(links[i].left == false)
                            {tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="OutputBuffers ID :- '+links[i].target.id+'" id='+links[i].target.id + flag++ +' type="text" readonly></td>';
                            var out = {id:links[i].target.id,position:null , size:null,type:null,break:null,from:null};
                            outB.push(out);
                            }
                            else{
                            tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="InputBuffers id:- '+links[i].target.id+'" id='+links[i].target.id + flag++ +' type="text" readonly></td>';
                            var out = {id:links[i].target.id,position:null , size:null,type:null,break:null,from:null};
                            inputB.push(out);
                            }
                            tableBody += '  <td><input  placeholder="position" id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  placeholder="size"     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  placeholder="type"     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  placeholder="break"    id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  placeholder="from"     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '</tr>';
                          }
                }
                if(links[i].target.id == ids.id)
                   if(links[i].source.id[0] == 'B'){
                     //alert(links[i].source.id+flag);
                     flag = 0;
                     tableBody += '<tr>';
                     if(links[i].left == true)
                     {tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="OutputBuffers ID :- '+links[i].source.id+'" id="'+links[i].source.id+''+ flag++ +'" type="text" readonly></td>';
                     var out = {id:links[i].source.id,position:null , size:null,type:null,break:null,from:null};
                     outB.push(out);}
                     else
                     {tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="InputBuffers id:- '+links[i].source.id+'" id='+links[i].source.id + flag++ +' type="text" readonly></td>';
                     var out = {id:links[i].source.id,position:null , size:null,type:null,break:null,from:null};
                     inputB.push(out);
                   }tableBody += '  <td><input  placeholder="position" id='+links[i].source.id + flag++ +' type="text"></td>';  //1
                     tableBody += '  <td><input  placeholder="size " id=   '+links[i].source.id + flag++ +'  type="text"></td>';
                     tableBody += '  <td><input  placeholder="type" id=    '+links[i].source.id + flag++ +'  type="text"></td>';
                     tableBody += '  <td><input  placeholder="break" id=   '+links[i].source.id + flag++ +'  type="text"></td>';
                     tableBody += '  <td><input  placeholder="from" id=    '+links[i].source.id + flag++ +'  type="text"></td>';//5
                     tableBody += '</tr>';

                   }
           }
  }

    document.getElementById('tablebody4').innerHTML = tableBody;
    var  tableBody1 = '';
    tableBody1 += ' <tr >';
    tableBody1 += '  <td><input  placeholder="Number of varArguments" id="n2" type="text"></td>';
    tableBody1 += '  <td><input  placeholder="Number of Arguments" id="n1" type="text"></td>';
    tableBody1 += '  <td><input  placeholder="Number of IObuffer" id="n3" type="text"></td>';
    tableBody1 += '  <td><input class="button-primary"  onclick="description()" value="update"  id="butt" type="button"/><td>';

    tableBody1 += '   </tr>';
    document.getElementById('tablebody5').innerHTML = tableBody1;
    document.getElementById('tablebody6').innerHTML = '';

    var kernel11 = {id:ids.id,out:outB,input:inputB,depend:depends,src:null,partition:null,Workdimension:null,IObuffer:[],varArguments:[],Arguments:[],name:null};
    kernel2 = kernel11;
    document.getElementById('label1').innerHTML = null;
  }
  else {
    document.getElementById('tablebody4').innerHTML = '';
    document.getElementById('tablebody5').innerHTML = '';
    document.getElementById('tablebody6').innerHTML = '';
    document.getElementById('label1').innerHTML = null;
  }
}

function View(){
   var count = Object.keys(kernel1).length;
   var g =0;
   alert(ids.id);
   var i;
   for(i=0;i<count;i++){
     if(kernel1[i].id == ids.id)
        {   g = 0; break; }
      g = 1;
   }
   if(g == 0){
     var lin = JSON.stringify(kernel1[i], undefined, 4);
    document.getElementById('label1').innerHTML = lin;
    // alert(lin);
   }
   else alert("Kernel description is not given");
}

function modify(){
  //document.getElementById('tablebody4').innerHTML = '';
  //document.getElementById('tablebody5').innerHTML = '';
  //document.getElementById('tablebody6').innerHTML = '';
  var count3 = Object.keys(kernel1).length;
  var i;
  var j = 0;
  //alert(count3+ids.id+ kernel1[0].id);
  for(j=0;j<count3;j++){
    if(kernel1[j].id == ids.id)
  {
  alert("Can procced");
  var tableBody = '';
  var depends = '[';
  var count = Object.keys(links).length;
  i = 0;
  var flag = 0;
  var inputB =[];
  var outB =[];
  document.getElementById('tablebody').innerHTML =ids.id;
      tableBody += '<tr>';
      tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="kernel ID:- '+ids.id+'" id="ID" type="text" readonly></td>';
      tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value='+kernel1[j].depend+' id='+ids.id + flag++ +' type="text" readonly></td>';
      tableBody += '  <td><input  value='+kernel1[j].name+' id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '  <td><input  value='+kernel1[j].Workdimension+' id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '  <td><input  value='+kernel1[j].partition+' id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '  <td><input  value='+kernel1[j].src+' id='+ids.id + flag++ +' type="text"></td>';
      tableBody += '</tr>';
      flag = 0;
      var z = 0 , zz = 0;
  for (i = 0; i < count; i++)
  if(ids.id[0] == 'k'){
       if(links[i].source.id == ids.id || links[i].target.id == ids.id)
           {
             if(links[i].source.id == ids.id)
                if(links[i].target.id[0] == 'B'){
                        {   //alert(links[i].target.id+flag);
                            flag = 0;

                            tableBody += '<tr>';
                            if(links[i].left == false)
                            {tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="OutputBuffers ID :- '+kernel1[j].out[z].id+'" id='+links[i].target.id + flag++ +' type="text" readonly></td>';
                            tableBody += '  <td><input  value='+kernel1[j].out[z].position+' id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].out[z].size+'     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].out[z].type+'     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].out[z].break+'    id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].out[z].from+'     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '</tr>';
                            z++;
                            var out = {id:links[i].target.id,position:null , size:null,type:null,break:null,from:null};
                            outB.push(out);
                            }
                            else{
                            tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="InputBuffers id:- '+kernel1[j].input[zz].id+'" id='+links[i].target.id + flag++ +' type="text" readonly></td>';
                            tableBody += '  <td><input  value='+kernel1[j].input[zz].position+' id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].input[zz].size+'     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].input[zz].type+'     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].input[zz].break+'    id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '  <td><input  value='+kernel1[j].input[zz].from+'     id='+links[i].target.id + flag++ +' type="text"></td>';
                            tableBody += '</tr>';
                            zz++;
                            var out = {id:links[i].target.id,position:null , size:null,type:null,break:null,from:null};
                            inputB.push(out);
                            }

                          }
                }
                if(links[i].target.id == ids.id)
                   if(links[i].source.id[0] == 'B'){
                     //alert(links[i].source.id+flag);
                     flag = 0;
                     tableBody += '<tr>';
                     if(links[i].left == true)
                     {
                     tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="OutputBuffers ID :- '+kernel1[j].out[z].id+'" id='+links[i].source.id + flag++ +' type="text" readonly></td>';
                     tableBody += '  <td><input  value='+kernel1[j].out[z].position+' id='+links[i].source.id + flag++ +' type="text"></td>';
                     tableBody += '  <td><input  value='+kernel1[j].out[z].size+'     id='+links[i].source.id + flag++ +' type="text"></td>';
                     tableBody += '  <td><input  value='+kernel1[j].out[z].type+'     id='+links[i].source.id + flag++ +' type="text"></td>';
                     tableBody += '  <td><input  value='+kernel1[j].out[z].break+'    id='+links[i].source.id + flag++ +' type="text"></td>';
                     tableBody += '  <td><input  value='+kernel1[j].out[z].from+'     id='+links[i].source.id + flag++ +' type="text"></td>';
                     tableBody += '</tr>';
                     z++;
                     var out = {id:links[i].source.id,position:null , size:null,type:null,break:null,from:null};
                     outB.push(out);}
                     else
                     {
                       tableBody += '  <td><input style="background-color:#ffffe0;font-size:15px;" value="InputBuffers id:- '+kernel1[j].input[zz].id+'" id='+links[i].source.id + flag++ +' type="text" readonly></td>';
                       tableBody += '  <td><input  value='+kernel1[j].input[zz].position+' id='+links[i].source.id + flag++ +' type="text"></td>';
                       tableBody += '  <td><input  value='+kernel1[j].input[zz].size+'     id='+links[i].source.id + flag++ +' type="text"></td>';
                       tableBody += '  <td><input  value='+kernel1[j].input[zz].type+'     id='+links[i].source.id + flag++ +' type="text"></td>';
                       tableBody += '  <td><input  value='+kernel1[j].input[zz].break+'    id='+links[i].source.id + flag++ +' type="text"></td>';
                       tableBody += '  <td><input  value='+kernel1[j].input[zz].from+'     id='+links[i].source.id + flag++ +' type="text"></td>';
                       tableBody += '</tr>';
                       zz++;
                       var out = {id:links[i].source.id,position:null , size:null,type:null,break:null,from:null};
                       inputB.push(out);
                   }
                   }

           }
           kernel2  = kernel1[j];
  }

    document.getElementById('tablebody4').innerHTML = tableBody;
    var  tableBody1 = '';
    tableBody1 += ' <tr >';
    tableBody1 += '  <td><input  value='+Object.keys(kernel2.varArguments).length+' id="n2" type="text"></td>';
    tableBody1 += '  <td><input  value='+Object.keys(kernel2.Arguments).length+' id="n1" type="text"></td>';
    tableBody1 += '  <td><input  value='+Object.keys(kernel2.IObuffer).length+' id="n3" type="text"></td>';
    tableBody1 += '   </tr>';
    document.getElementById('tablebody5').innerHTML = tableBody1;
    var i =0;
    var tableBody = '';
    var count  = 0;
    //alert(document.getElementById('n1').value);
     if(Object.keys(kernel2.Arguments).length != 0 && Object.keys(kernel2.Arguments).length){
       tableBody += '<tr>';
       tableBody += '<td> <h5 align="center"> Arguments</h5></td>';
       tableBody += '</tr>';
     }
      for(i=0;i<Object.keys(kernel2.Arguments).length;i++)
        {       count = 0;
                tableBody += '<tr>';
                tableBody += '  <td><input  value='+kernel2.Arguments[i].position+' id='+i + count++ +' type="text"></td>';
                tableBody += '  <td><input  value='+kernel2.Arguments[i].size+' id='+i + count++ +' type="text"></td>';
                tableBody += '  <td><input  value='+kernel2.Arguments[i].type+' id='+i  + count++ +' type="text"></td>';
                tableBody += '  <td><input  value='+kernel2.Arguments[i].break+' id='+i + count++ +' type="text"></td>';
                tableBody += '  <td><input  value='+kernel2.Arguments[i].from+' id='+i + count++ +' type="text"></td>';
                tableBody += '</tr>';
        }
        if(Object.keys(kernel2.varArguments).length){
        tableBody += '<tr>';
        tableBody += '<td> <h5 align="center"> VarArguments</h5></td>';
        tableBody += '</tr>';
        }
        count = 0;
        for(i=0;i<Object.keys(kernel2.varArguments).length;i++)
          {
                  tableBody += '<tr>';
                  tableBody += '  <td><input  value='+kernel2.varArguments[i].position+' id='+"n2" +i +' type="text"></td>';
                  tableBody += '  <td><input  value='+kernel2.varArguments[i].size+' id='+"n21" +i +' type="text"></td>';
                  tableBody += '  <td><input  value='+kernel2.varArguments[i].type+' id='+"n22" +i +' type="text"></td>';
                  tableBody += '</tr>';
          }
     if(Object.keys(kernel2.IObuffer).length){
          tableBody += '<tr>';
          tableBody += '<td> <h5 align="center"> IObuffer</h5></td>'
          tableBody += '</tr>';
        }
          count = 0;
        for(i=0;i<Object.keys(kernel2.IObuffer).length;i++)
          {
                  tableBody += '<tr>';
                  tableBody += '  <td><input  value='+kernel2.IObuffer[i].position+' id='+"n3" + i +' type="text"></td>';
                  tableBody += '  <td><input  value='+kernel2.IObuffer[i].size+' id='+"n31" + i +' type="text"></td>';
                  tableBody += '  <td><input  value='+kernel2.IObuffer[i].type+' id='+"n32" + i +' type="text"></td>';
                  tableBody += '</tr>';
          }



      var tableBo = '<input class="button-primary"  onclick="done()" value="update"  		id="final" type="button"/>';
      document.getElementById('tablebody6').innerHTML = tableBody;
      document.getElementById('tablebody7').innerHTML = tableBo;
    //var kernel11 = {id:ids.id,out:outB,input:inputB,depend:depends,src:null,partition:null,Workdimension:null,IObuffer:[],varArguments:[],Arguments:[],name:null};
    //kernel2 = kernel11;
    document.getElementById('label1').innerHTML = null;
  }
}
}
svg.on("dblclick",check2)
  .on('mousemove', mousemove)
  .on('mouseup', mouseup)
  .on('mousedown', mousedown);
d3.select(window)
  .on('keydown', keydown)
  .on('keyup', keyup);
