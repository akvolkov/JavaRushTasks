package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home PC Volkov on 17.03.2018.
 */
public class StatisticAdvertisementManager {
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> activeVideos = new ArrayList<Advertisement>();
        for (Advertisement advertice: advertisementStorage.list()
             ) {
            if (advertice.getHits() > 0) {
                activeVideos.add(advertice);
            }
        }
        return activeVideos;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> archvedVideos = new ArrayList<Advertisement>();
        for (Advertisement archive: advertisementStorage.list()
             ) {
            if (archive.getHits() <= 0) {
                archvedVideos.add(archive);
            }
        }
        return archvedVideos;
    }
}
