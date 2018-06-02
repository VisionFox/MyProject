package com.itcast.day20PookerProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class DouDiZhu {
    public static void main(String[] args) {
        //制作牌
        System.out.println("组牌");
        HashMap<Integer,String> pooker=new HashMap<Integer, String>();
        ArrayList<Integer> pookerId=new ArrayList<Integer>();
        String[] colors={"♠","♥","♣","♦"};
        String[] numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        int index=2;
        for (String number:numbers){
            for (String color:colors){
                pooker.put(index,number+color);
                pookerId.add(index);
                ++index;
            }
        }

        pookerId.add(0);pookerId.add(1);
        pooker.put(0,"大王");
        pooker.put(1,"小王");
        System.out.println(pooker);

        //洗牌
        System.out.println("洗牌");
        Collections.shuffle(pookerId);
        System.out.println(pookerId);

        //创建玩家和底牌
        ArrayList<Integer> player1=new ArrayList<Integer>();
        ArrayList<Integer> player2=new ArrayList<Integer>();
        ArrayList<Integer> player3=new ArrayList<Integer>();
        ArrayList<Integer> botom=new ArrayList<Integer>();

        //发牌
        System.out.println("发牌");
        for(int i=0;i<pookerId.size();++i){
            if (i<3){
                botom.add(pookerId.get(i));
                continue;
            }
            if (i%3==0){
                player1.add(pookerId.get(i));
            }
            if (i%3==1){
                player2.add(pookerId.get(i));
            }
            if (i%3==2){
                player3.add(pookerId.get(i));
            }
        }
        System.out.println("发牌完毕");
        //玩家对自己的牌进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        //看牌
        System.out.println("看牌");
        System.out.println("play1: ");
        look(player1,pooker);
        System.out.println("play2: ");
        look(player2,pooker);
        System.out.println("play3: ");
        look(player3,pooker);
        System.out.println("底牌： ");
        look(botom,pooker);
    }
    public static void look(ArrayList<Integer> player,HashMap<Integer,String> pooker){
        for (Integer pookerId:player){
            System.out.print(pooker.get(pookerId)+"  ");
        }
        System.out.println();
    }
}
