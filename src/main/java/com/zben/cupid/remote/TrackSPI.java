package com.zben.cupid.remote;


import com.zben.cupid.track.model.Track;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午10:33 2018/4/13
 */
public interface TrackSPI {
    String save(Track track);
}
