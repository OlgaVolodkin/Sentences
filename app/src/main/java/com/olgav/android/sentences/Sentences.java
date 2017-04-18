package com.olgav.android.sentences;

import java.util.ArrayList;

/**
 * Created by olga on 3/14/17.
 */

public class Sentences {

    ArrayList<String> hebSentencesArray = new ArrayList<>();
    ArrayList<String> engSentencesArray = new ArrayList<>();


    public ArrayList<String> buildHeb() {
        hebSentencesArray.add("הצמיחה הגדולה ביותר של האדם נעשית כשהוא נכנס לתחומו של הלא ידוע (רובין שארמה)");
        hebSentencesArray.add("יש אשר חולמים חלומות, ויש אשר נשארים ערים ומגשימים אותם (אלברט איינשטיין)");
        hebSentencesArray.add("יש קו דק בין הדמיון למציאות – אתה צריך לצייר אותו (ב. קוויליאם)");
        hebSentencesArray.add("ניסוח בעיה חיוני לפעמים יותר מפתרונה (אלברט איינשטיין)");
        hebSentencesArray.add("אדם לא יכול לגלות אוקיינוסים חדשים מבלי שיותר על ההכרח לראות כל הזמן את החוף (אנדרה נייד)");
        hebSentencesArray.add("כאשר אנחנו מאבדים את היכולת להיות שונים אנו מאבדים את הזכות להיות חופשיים (צירלס איוון הוגס)");
        hebSentencesArray.add("מכשולים הם הדבר המפחיד שאתה רואה, ברגע שאתה מסיט את עיניך מהמטרה (הנרי פורד)");
        hebSentencesArray.add("גישה היא דבר קטן שעושה הבדל גדול (וינסטון צ'רציל)");
        hebSentencesArray.add("העתיד שייך לאלה המאמינים ביופיים של חלומותיהם (אלינור רוזוולט)");
        hebSentencesArray.add("רק מי שלוקח סיכון, מגלה כמה רחוק הוא יכול להגיע (אלברט איינשטיין)");

        return hebSentencesArray;
    }


    public ArrayList<String> buildEng() {
        engSentencesArray.add("My goal is not to be better than anyone else, but to be better than i used to be (Dr. Wayne Dyer)");
        engSentencesArray.add("Trust your intuition and be guided by love (Charles Eisenstein)");
        engSentencesArray.add("Do all things with kindness");
        engSentencesArray.add("Nothing can make our lives, or the lives of other people, more beautiful than perpetual kindness. (Tolstoy)");
        engSentencesArray.add("Once upon a time you were a little child with a big dreams than you promised you'd make real one day.\n" +
                "Don't disappoint yourself ");
        engSentencesArray.add("The 3 C's of life: CHOICES, CHANCES and CHANGES.\n" +
                "You must make a choice to take a chance or you will never change (Zig Ziglar)");
        engSentencesArray.add("KARMA what goes around comes around keep your circle positive.\n" +
                "Speak good words. Think good thoughts. Do good deeds");
        engSentencesArray.add("Keep calm and let KARMA finish it");
        engSentencesArray.add("Never stop doing little things for others.\n " +
                        "Sometimes those little things occupy the biggest part of their hearts");
        engSentencesArray.add("Tomorrow is the first blank page of a 365-page book. Write a good one. (Brad Paisley)");

        return engSentencesArray;
    }
}
