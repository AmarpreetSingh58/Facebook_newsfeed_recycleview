package com.amarpreetsinghprojects.facebook_newsfeed_recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        final String formattedDate = df.format(c.getTime());


        final ArrayList<Feed_elements> feed_elemetsArrayList = new ArrayList<>();
        feed_elemetsArrayList.add(new Feed_elements("Amarpreet Singh",formattedDate,"feed\n" +
                "[feed] \n" +
                "Spell  Syllables\n" +
                "Synonyms Examples Word Origin\n" +
                "See more synonyms on Thesaurus.com\n" +
                "verb (used with object), fed, feeding.\n" +
                "1.\n" +
                "to give food to; supply with nourishment:\n" +
                "to feed a child.\n" +
                "2.\n" +
                "to yield or serve as food for:\n" +
                "This land has fed 10 generations."));
        feed_elemetsArrayList.add(new Feed_elements("Nikka", formattedDate, "A flock of crows is known as a murder."));
        feed_elemetsArrayList.add(new Feed_elements("Newton", formattedDate, "Gravitational lensing: Light around a massive object, such as a black hole, is bent, causing it to act as a lens for the things that lie behind it. Astronomers routinely use this method to study stars and galaxies behind massive objects.\n" +
                "\n" +
                "Einstein's Cross, a quasar in the Pegasus constellation, is an excellent example of gravitational lensing. The quasar is about 8 billion light-years from Earth, and sits behind a galaxy that is 400 million light-years away. Four images of the quasar appear around the galaxy because the intense gravity of the galaxy bends the light coming from the quasar.\n" +
                "\n" +
                "Gravitational lensing can allow scientists to see some pretty cool things, but until recently, what they spotted around the lens has remained fairly static. However, since the light traveling around the lens takes a different path, each traveling over a different amount of time, scientists were able to observe a supernova occur four different times as it was magnified by a massive galaxy."));
        feed_elemetsArrayList.add(new Feed_elements("Mirenda", formattedDate, " Happy Birthday"));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        final Feed_adapter adapter = new Feed_adapter(feed_elemetsArrayList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button addContents = (Button)findViewById(R.id.add_button);

        addContents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                feed_elemetsArrayList.add(0,new Feed_elements("Knock", formattedDate, "New DB11 isn't the only car good at cross-continental jaunts"));
                feed_elemetsArrayList.add(2,new Feed_elements("Cleverboard", formattedDate,"The Android operating system was developed by Android Inc., in 2004 backed by Google. Later Google bought it in 2005 at a price of $50 million."));
                feed_elemetsArrayList.add(1,new Feed_elements("Andy", formattedDate, "Android operating system, was developed as a platform for digital cameras.  But the makers later changed their focus to smart phones as they saw its potential. - See more at: http://www.spinfold.com/15-less-known-facts-about-android/#sthash.mb6CqQms.dpuf \n" +
                        "Google launched Android operating system in November 5, 2007, which is a Linux based software system. - See more at: http://www.spinfold.com/15-less-known-facts-about-android/#sthash.mb6CqQms.dpuf \n" +
                        "HTC Dream or T_Mobile G1 is the first ever smartphone to run on the Android operating system, this mobile phone was released in the year 2008. - See more at: http://www.spinfold.com/15-less-known-facts-about-android/#sthash.mb6CqQms.dpuf \n" +
                        "Google’s Android operating system, has attained over a billion activations on devices like smartphones and tablets. - See more at: http://www.spinfold.com/15-less-known-facts-about-android/#sthash.mb6CqQms.dpuf"));
                feed_elemetsArrayList.add(3,new Feed_elements("May", formattedDate, "The new Aston Martin DB11 is kind of a big deal, not least because by our reckoning, it’s the first Aston since the old Vanquish that hasn’t used a version of the V/H platform (forget the Cygnet). It’s done Aston well over the years, admittedly, but hey, times change. \n" +
                        "\n" +
                        "Same goes for the glorious 6.0-litre V12, which likewise can trace its heritage back decades. The DB11 still has a V12, but it’s lost 800ccs of capacity and gained a couple of turbochargers for a total of 600bhp. Which is adequate. \n" +
                        "\n" +
                        "It’s not flawless, the DB11, but it is pretty damn good, which you’ll know if you’ve read our review. Though when it comes to continent-crushers, the competition is stiff. Click through the gallery for seven cars we reckon could be the £155K DB11’s closest competitors – these are the cars it has to beat."));

                adapter.notifyDataSetChanged();
            }
        });
    }
}
