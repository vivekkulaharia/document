package com.example.vivek.aratiapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vivek on 12/7/16.
 */
public class mangalarti extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mangalarti);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("(1)\n" +
                        "\n" +
                        "samsara-davanala-lidha-loka\n" +
                        "\n" +
                        "tranaya karunya-ghanaghanatvam\n" +
                        "\n" +
                        "praptasya kalyana-gunarnavasya\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(2)\n" +
                        "\n" +
                        "mahaprabhoh kirtana-nritya-gita-\n" +
                        "\n" +
                        "vaditra-madyan-manaso rasena\n" +
                        "\n" +
                        "romancha-kampashru-taranga-bhajo\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(3)\n" +
                        "\n" +
                        "shri-vigraharadhana-nitya-nana-\n" +
                        "\n" +
                        "shringara-tan-mandira-marjanadau\n" +
                        "\n" +
                        "yuktasya bhaktamsh cha niyunjato ‘pi\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(4)\n" +
                        "\n" +
                        "chatur-vidha-shri-bhagavat-prasada-\n" +
                        "\n" +
                        "svadv-anna-triptan hari-bhakta-sanghan\n" +
                        "\n" +
                        "kritvaiva triptim bhajatah sadaiva\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(5)\n" +
                        "\n" +
                        "shri-radhika-madhavayor apara-\n" +
                        "\n" +
                        "madhurya-lila-guna-rupa-namnam\n" +
                        "\n" +
                        "prati-kshanasvadana-lolupasya\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(6)\n" +
                        "\n" +
                        "nikunja-yuno rati-keli-siddhyai\n" +
                        "\n" +
                        "ya yalibhir yuktir apekshaniya\n" +
                        "\n" +
                        "tatrati-dakshyad ati-vallabhasya\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(7)\n" +
                        "\n" +
                        "sakshad-dharitvena samasta-shastrair\n" +
                        "\n" +
                        "uktas tatha bhavyata eva sadbhih\n" +
                        "\n" +
                        "kintu prabhor yah priya eva tasya\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(8)\n" +
                        "\n" +
                        "yasya prasadad bhagavat-prasado\n" +
                        "\n" +
                        "yasyaprasadan na gatih kuto ‘pi\n" +
                        "\n" +
                        "dhyayan stuvams tasya yashas tri-sandhyam\n" +
                        "\n" +
                        "vande guroh shri-charanaravindam\n" +
                        "\n" +
                        "(9)\n" +
                        "\n" +
                        "srimad-guror ashtakam etad uccair\n" +
                        "\n" +
                        "brahme muhurte pathati prayatnat\n" +
                        "\n" +
                        "yas tena vrindavana-natha-sakshat-\n" +
                        "\n" +
                        "sevaiva labhya janusha ‘nta eva");
            }
        });


        Button button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("संसार-दावानल-लीढ-लोक-\n" +
                        "त्राणाय कारुण्य-घनाघनत्वम्\n" +
                        "प्राप्तस्य कल्याण-गुणार्णवस्य\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "महाप्रभोः कीर्तन-नृत्य-गीत-\n" +
                        "वादित्र-माद्यन-मनसो रसेन\n" +
                        "रोमाञ्च-कम्पाश्रु-तरङ्ग-भाजो\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "श्री-विग्रहाराधन-नित्य-नाना-\n" +
                        "शृङ्गार-तन्-मन्दिर-मार्जनादौ\n" +
                        "युक्तस्य भक्तांश् च नियुञ्जतोऽपि\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "चतुर्-विध-श्री-भगवत्-प्रसाद-\n" +
                        "स्वाद्व्-अन्न-तृप्तान् हरि-भक्त-सङ्घान्\n" +
                        "कृत्वैव तृप्तिं भजतः सदैव\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "श्री-राधिका-माधवयोर्-अपार-\n" +
                        "माधुर्य-लीला गुण-रूप-नाम्नाम्\n" +
                        "प्रति-क्षणास्वादन-लोलुपस्य\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "निकुञ्ज-यूनो रति-केलि-सिद्ध्यै\n" +
                        "या यालिभिर् युक्तिर् अपेक्षणीया\n" +
                        "तत्राति-दाक्ष्याद् अति-वल्लभस्य\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "साक्षाद् धरित्वेन समस्त-शास्त्रैर्\n" +
                        "उक्तस् तथा भाव्यत एव सद्भिः\n" +
                        "किन्तु प्रभोर् यः प्रिय एव तस्य\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "यस्य प्रसादाद् भगवत्-प्रसादो\n" +
                        "यस्याप्रसादान् न गतिः कुतोऽपि\n" +
                        "ध्यायन् स्तुवंस् तस्य यशस् त्रि-सन्ध्यं\n" +
                        "वन्दे गुरोः श्री-चरणारविन्दम्\n" +
                        " \n" +
                        "श्रीमद्-गुरोर् अष्टकम् एतद् उच्चैर्\n" +
                        "ब्राह्मे मुहूर्ते पठति प्रयत्नात्\n" +
                        "यस् तेन वृन्दावन-नाथ साक्षात्\n" +
                        "सेवैव लभ्या जुषणोऽन्त एव");
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("(১)\n" +
                        "সংসার দাবানল লীঢ় লোক-\n" +
                        "ত্রাণায় কারুণ্যঘনাঘণত্বম্\n" +
                        "প্রাপ্তস্য কল্যাণ গুণার্ণবস্য\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(২)\n" +
                        "মহাপ্রভোঃ কীর্তন নৃত্য গীত-\n" +
                        "বাদিত্রমাদ্যন্মনসো রসেন\n" +
                        "রোমাঞ্চ কম্পাশ্রু তরঙ্গভাজো\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৩)\n" +
                        "শ্রীবিগ্রহারাধন নিত্য নানা-\n" +
                        "শৃঙ্গার তন্মন্দিরমার্জনাদৌ\n" +
                        "যুক্তাস্য ভক্তাংশ্চ নিযুঞ্জতোঽপি\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৪)\n" +
                        "চতুর্বিধ শ্রীভগবৎপ্রসাদ-\n" +
                        "স্বাদন্নতৃপ্তান্ হরিভক্তসঙ্ঘান্\n" +
                        "কৃত্বৈব তৃপ্তিং ভজতঃ সদৈব\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৫)\n" +
                        "শ্রীরাধিকামাধবয়োরপার –\n" +
                        "মাধুর্যলীলা গুণ রূপ নাম্নান্\n" +
                        "প্রতিক্ষণাস্বাদান লোলুপস্য\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৬)\n" +
                        "নিকুঞ্জযুনো  রতিকেলিসিদ্ধ্যৈ –\n" +
                        "যা যালিভির্যুক্তিরপেক্ষণীয়া\n" +
                        "তত্রাদিদাক্ষাদতিবল্লভস্য\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৭)\n" +
                        "সাক্ষাদ্ধরিত্বেন সমস্তশাস্ত্রৈ –\n" +
                        "রুক্তস্তথা ভাব্যত এব সদ্ভিঃ\n" +
                        "কিন্তু প্রভোর্যঃ প্রিয় এব তস্য\n" +
                        " বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৮)\n" +
                        "যস্য প্রসাদাদ্ভগবৎপ্রসাদো\n" +
                        "যস্যপ্রসাদান্ন গতিঃ কুতোহপি\n" +
                        "ধ্যায়ংস্তবংস্তস্য যশস্ত্রিসন্ধ্যং\n" +
                        "বন্দে গুরোঃ শ্রীচরণারবিন্দম্  \n" +
                        " \n" +
                        "(৯)\n" +
                        "শ্রীমদ্গুরোরষ্টকমেতদুচ্চৈর্\u200C\n" +
                        "ব্রাহ্মে মুহূর্তে পঠতি প্রয়ত্নাৎ\n" +
                        "যস্তেন বৃন্দাবননাথ সাক্ষাৎ\n" +
                        "সেবৈব লভ্যা জুষণোঽন্ত এব");
            }
        });


    }
}

