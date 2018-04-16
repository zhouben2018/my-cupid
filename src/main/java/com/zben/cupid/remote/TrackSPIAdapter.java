package com.zben.cupid.remote;

import com.zben.cupid.track.api.TrackService;
import com.zben.cupid.track.model.Track;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午10:34 2018/4/13
 */
@Service
@Slf4j
public class TrackSPIAdapter implements TrackSPI {

    @Autowired
    private TrackService trackService;

    @Override
    public String save(Track track) {
        try {
            return trackService.save(track);
        } catch (Exception e) {
            log.error("save track error", e);
            e.printStackTrace();
        }
        return null;
    }
}



































