package com.example.vivek.aratiapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vivek on 11/7/16.
 */
public class prabhupada extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prabhupada);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("(1)\n" +
                        "śrī-guru-caraṇa-padma, kevala-bhakati-sadma,\n" +
                        "bando muñi sāvadhāna mate\n" +
                        "jāhāra prasāde bhāi, e bhava toriyā jāi,\n" +
                        "kṛṣṇa-prāpti hoy jāhā ha'te\n" +
                        " \n" +
                        "(2)\n" +
                        "guru-mukha-padma-vākya, cittete koribo aikya,\n" +
                        "ār nā koriho mane āśā\n" +
                        "śrī-guru-caraṇe rati, ei se uttama-gati,\n" +
                        "je prasāde pūre sarva āśā\n" +
                        " \n" +
                        "(3)\n" +
                        "cakṣu-dān dilo jei, janme janme prabhu sei,\n" +
                        "divya jñān hṛde prokāśito\n" +
                        "prema-bhakti jāhā hoite, avidyā vināśa jāte,\n" +
                        "vede gāy jāhāra carito\n" +
                        " \n" +
                        "(4)\n" +
                        "śrī-guru karuṇā-sindhu, adhama janāra bandhu,\n" +
                        "lokanāth lokera jīvana\n" +
                        "hā hā prabhu koro doyā, deho more pada-chāyā,\n" +
                        "ebe jaśa ghuṣuk tribhuvana\n" +
                        " \n" +
                        "(5)\n" +
                        "vaiṣṇava caraṇa reṇu, bhūṣaṇa koriyā tanu,\n" +
                        "yāhā hoite anubhava hoy\n" +
                        "mārjana hoy bhajana, sādhu sańge anukṣaṇa,\n" +
                        "ajñāna avidyā parājaya\n" +
                        " \n" +
                        "(6)\n" +
                        "jaya sanātana rūpa, prema bhakti rasa kūpa\n" +
                        "yugala ujjvalamaya tanu\n" +
                        "yāhāra prasāde loka, pāsarilo sab śoka,\n" +
                        "prakaṭa kalapa taru janu\n" +
                        " \n" +
                        "(7)\n" +
                        "prema bhakti rīti yoto, nija granthe suvekata\n" +
                        "likhiyāchen dui mahāśaya\n" +
                        "yāhāra śravaṇa hoite, premānande bhāse cite,\n" +
                        "yugala madhura rasāśraya\n" +
                        " \n" +
                        "(8)\n" +
                        "yugala kiśora prema, lakṣa bāṇa yeno hema\n" +
                        "heno dhana prakāśilo yārā\n" +
                        "jaya rūpa sanātana, deho more prema dhana\n" +
                        "se ratana more gole hārā\n" +
                        " \n" +
                        "(9)\n" +
                        "bhāgavata śāstra marma, nava vidhā bhakti dharma,\n" +
                        "sadāi koribo susevana\n" +
                        "anya devāśraya nāi, tomāre kohilo bhāi,\n" +
                        "ei bhakti parama bhajana\n" +
                        " \n" +
                        "(10)\n" +
                        "sādhu śāstra guru vākya, hṛdoye koriyā aikya,\n" +
                        "satata bhāsibo prema mājhe\n" +
                        "karmī jñānī bhakti hīna, ihāke koribo bhina,\n" +
                        "narottama ei tattva gāje");
            }
        });


        Button button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("(১)\n" +
                        "শ্রী গুরু চরণ পদ্ম, কেবল ভকতি সদ্ম\n" +
                        "বন্দোঁ মুঞি সাবধান মতে\n" +
                        "যাহার প্রসাদে ভাই, এই ভব তরিয়া যায়\n" +
                        "কৃষ্ণ প্রাপ্তি হোয় যাহা হৈতে\n" +
                        " \n" +
                        "(২)\n" +
                        "গুরু মুখ পদ্ম বাক্য, চিত্তেতে করিব ঐক্য\n" +
                        "আর না কোরিহো মনে আশা\n" +
                        "শ্রী গুরু চরণে রতি, এই সে উত্তম গতি,\n" +
                        "যে প্রসাদে পূরে সর্ব্ব আশা\n" +
                        " \n" +
                        "(৩)\n" +
                        "চক্ষু দান দিল যেই, জন্মে জন্মে প্রভু সেই,\n" +
                        "দিব্য জ্ঞান হৃদে প্রকাশিত\n" +
                        "প্রেম ভক্তি যাহা হৈতে, অবিদ্যা বিনাশ যাতে\n" +
                        "বেদে গায় যাহার চরিত\n" +
                        " \n" +
                        "(৪)\n" +
                        "শ্রী গুরু করুণা সিন্ধু, অধম জনার বন্ধু,\n" +
                        "লোকনাথ লোকের জীবন\n" +
                        "হা হা প্রভু! কর দয়া, দেহো মোরে পদ-ছায়া,\n" +
                        "এবে যশঃ ঘুষুক ত্রি-ভুবন\n" +
                        " \n" +
                        "(৫)\n" +
                        "বৈষ্ণব চরণ রেণু, ভূষণ করিয়া তনু,\n" +
                        "যাহা হৈতে অনুভব হয়\n" +
                        "মার্জন হয় ভজন, সাধু সঙ্গে অনুক্ষণ,\n" +
                        "অজ্ঞান অবিদ্যা পরাজয়\n" +
                        " \n" +
                        "(৬)\n" +
                        "জয় সনাতন রূপ, প্রেম ভক্তি রস কূপ\n" +
                        "যুগল উজ্জ্বল-ময় তনু\n" +
                        "যাহার প্রসাদে লোক, পাসরিল সব শোক,\n" +
                        "প্রকট-কলপ-তরু জনু\n" +
                        " \n" +
                        "(৭)\n" +
                        "প্রেম ভক্তি রীতি যোতো, নিজ গ্রন্থে সুবেকত\n" +
                        "লিখিয়াছেন দুই মহাশয়\n" +
                        "যাহার শ্রবণ হৈতে, প্রেমানন্দে ভাসে চিতে,\n" +
                        "যুগল মধুর রসাশ্রয়\n" +
                        " \n" +
                        "(৮)\n" +
                        "যুগল কিশোর প্রেম, লক্ষ বাণ যেন হেম\n" +
                        "হেন ধন প্রকাশিল যারা\n" +
                        "জয় রূপ-সনাতন, দেহো মোরে প্রেম-ধন\n" +
                        "সে রতন মোরে গলে হারা\n" +
                        " \n" +
                        "(৯)\n" +
                        "ভাগবত শাস্ত্র মর্ম্ম, নব বিধা ভক্তি ধর্ম্ম,\n" +
                        "সদাই করিব সুসেবন\n" +
                        "অন্য দেবাশ্রয় নাই, তোমারে কহিল ভাই,\n" +
                        "এই ভক্তি পরম ভজন\n" +
                        " \n" +
                        "(১০)\n" +
                        "সাধু শাস্ত্র গুরু বাক্য, হৃদয়ে করিযা ঐক্য,\n" +
                        "সতত ভাসিব প্রেম মাঝে\n" +
                        "কর্ম্মী জ্ঞানী ভক্তি হীন, ইহাকে করিব ভিন,\n" +
                        "নরোত্তম এই তত্ত্ব গাজে");
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("(୧)\n" +
                        "ଶ୍ରୀ-ଗୁରୁ-ଚରଣ-ପଦ୍ମ, କେବଲ-ଭକତି-ସଦ୍ମ,\n" +
                        "ବନ୍ଦୋ ମୁନି ସାବଧାନ ମତେ\n" +
                        "ଯାହାର ପ୍ରସାଦେ ଭାଇ, ଏ ଭବ ତୋରିୟା ଜାଇ,\n" +
                        "କୃଷ୍ଣ-ପ୍ରାପ୍ତି ହୋଇ ଯାହା ହଽତେ\n" +
                        " \n" +
                        "(୨)\n" +
                        "ଗୁରୁ-ମୁଖ-ପଦ୍ମ-ବାକ୍ୟ, ଚିତ୍ତେତେ କୋରିବୋ ଐକ୍ୟ,\n" +
                        "ଆର୍ ନା କୋରିହୋ ମନେ ଆଶା\n" +
                        "ଶ୍ରୀ-ଗୁରୁ-ଚରଣେ ରତି, ଏଇ ସେ ଉତ୍ତମ-ଗତି,\n" +
                        "ଜେ ପ୍ରସାଦେ ପୂରେ ସର୍ବ ଆଶା\n" +
                        " \n" +
                        "(୩)\n" +
                        "ଚକ୍ଷ୍ୟୁ-ଦାନ୍ ଦିଲୋ ଯେଇ, ଜନ୍ମେ ଜନ୍ମେ ପ୍ରଭୁ ସେଇ,\n" +
                        "ଦିବ୍ୟ ଜ୍ଞାନ୍ ହୃଦେ ପ୍ରୋକାଶିତୋ\n" +
                        "ପ୍ରେମ-ଭକ୍ତି ଜାହା ହୋଇତେ, ଅବିଦ୍ୟା ବିନାଶ ଜାତେ,\n" +
                        "ବେଦେ ଗାଇ ଜାହାର ଚରିତୋ\n" +
                        " \n" +
                        "(୪)\n" +
                        "ଶ୍ରୀ-ଗୁରୁ କରୁଣା-ସିନ୍ଧୁ, ଅଧମ ଜନାର ବନ୍ଧୁ,\n" +
                        "ଲୋକନାଥ୍ ଲୋକେର ଜୀବନ\n" +
                        "ହା ହା ପ୍ରଭୁ କୋରୋ ଦୋୟା, ଦେହୋ ମୋରେ ପଦ-ଛାୟା,\n" +
                        "ଏବେ ଯଶ ଘୁଷୁକ୍ ତ୍ରିଭୁବନ\n" +
                        " \n" +
                        "(୫)\n" +
                        "ବୈଷ୍ଣବ ଚରଣ ରେଣୁ, ଭୂଷଣ କୋରିୟା ତନୁ,\n" +
                        "ୟାହା ହୋଇତେ ଅନୁଭବ ହୋୟ୍\n" +
                        "ମାର୍ଜନ ହୋଇ ଭଜନ, ସାଧୁ ସଙ୍ଗେ ଅନୁକ୍ଷଣ,\n" +
                        "ଅଜ୍ଞାନ ଅବିଦ୍ୟା ପରାଜୟ\n" +
                        " \n" +
                        "(୬)\n" +
                        "ଜୟ ସନାତନ ରୂପ, ପ୍ରେମ ଭକ୍ତି ରସ କୂପ\n" +
                        "ୟୁଗଲ ଉଜ୍ଜ୍ବଲମୟ ତନୁ\n" +
                        "ଯାହାର ପ୍ରସାଦେ ଲୋକ, ପାସରିଲୋ ସବ୍ ଶୋକ,\n" +
                        "ପ୍ରକଟ କଲପ ତରୁ ଜନୁ\n" +
                        " \n" +
                        "(୭)\n" +
                        "ପ୍ରେମ ଭକ୍ତି ରୀତି ୟୋତୋ, ନିଜ ଗ୍ରନ୍ଥେ ସୁବେକତ\n" +
                        "ଲିଖିୟାଚେନ୍ ଦୁଇ ମହାଶୟ\n" +
                        "ୟାହାର ଶ୍ରବଣ ହୋଇତେ, ପ୍ରେମାନନ୍ଦେ ଭାସେ ଚିତେ,\n" +
                        "ୟୁଗଲ ମଧୁର ରସାଶ୍ରୟ\n" +
                        " \n" +
                        "(୮)\n" +
                        "ୟୁଗଲ କିଶୋର ପ୍ରେମ, ଲକ୍ଷ ବାଣ ୟେନୋ ହେମ\n" +
                        "ହେନୋ ଧନ ପ୍ରକାଶିଲୋ ୟାରା\n" +
                        "ଜୟ ରୂପ ସନାତନ, ଦେହୋ ମୋରେ ପ୍ରେମ ଧନ\n" +
                        "ସେ ରତନ ମୋରେ ଗୋଲେ ହାରା\n" +
                        " \n" +
                        "(୯)\n" +
                        "ଭାଗବତ ଶାସ୍ତ୍ର ମର୍ମ, ନବ ବିଧା ଭକ୍ତି ଧର୍ମ,\n" +
                        "ସଦାଇ କୋରିବୋ ସୁସେବନ\n" +
                        "ଅନ୍ୟ ଦେବାଶ୍ରୟ ନାଇ, ତୋମାରେ କୋହିଲୋ ଭାଇ,\n" +
                        "ଏଇ ଭକ୍ତି ପରମ ଭଜନ\n" +
                        " \n" +
                        "(୧୦)\n" +
                        "ସାଧୁ ଶାସ୍ତ୍ର ଗୁରୁ ବାକ୍ୟ, ହୃଦୋୟେ କୋରିୟା ଐକ୍ୟ,\n" +
                        "ସତତ ଭାସିବୋ ପ୍ରେମ ମାଝେ\n" +
                        "କର୍ମୀ ଜ୍ଞାନୀ ଭକ୍ତି ହୀନ, ଇହାକେ କୋରିବୋ ଭିନ,\n" +
                        "ନରୋତ୍ତମ ଏଇ ତତ୍ତ୍ବ ଗାଜେ");
            }
        });


    }
}
