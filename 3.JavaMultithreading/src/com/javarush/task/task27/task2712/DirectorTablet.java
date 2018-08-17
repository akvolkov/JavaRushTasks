package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Home PC Volkov on 15.03.2018.
 */
public class DirectorTablet {
    public void printAdvertisementProfit(){// какую сумму заработали на рекламе, сгруппировать по дням

            Map<String, Double> map = StatisticManager.getInstance().getAdvertisementAmount();
            double totalAmount = 0;
            for (Map.Entry<String, Double> entry : map.entrySet())
            {
                totalAmount += entry.getValue();
                System.out.println(entry.getKey() + " - " + String.format("%.2f", entry.getValue()));
            }
            System.out.println(String.format("Total - %.2f", totalAmount));


    }

    public void printCookWorkloading(){ // ззагрузка (рабочее время) повара, сгруппировать по дням
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getCookWorkloading();

        for (Map.Entry<String, Map<String, Integer>> entry1 : map.entrySet())
        {
            System.out.println(entry1.getKey());
            for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet())
            {
                System.out.println(entry2.getKey() + " - " + entry2.getValue() + " min");
            }
        }
    }

    public void printActiveVideoSet(){ // список активных роликов и оставшееся количество показов по каждому
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        Collections.sort(list, comp);
        for (Advertisement adv: list
             ) {
            ConsoleHelper.writeMessage(adv.getName() + " - " + adv.getHits());
        }


    }

    public void printArchivedVideoSet(){ // список неактивных роликов (с оставшемся количеством показов равным нулю)
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getArchivedVideoSet();
        Collections.sort(list, comp);
        for (Advertisement adv: list
                ) {
            ConsoleHelper.writeMessage(adv.getName());
        }
    }

    Comparator<Advertisement> comp = new Comparator<Advertisement>() {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {

            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };
}
