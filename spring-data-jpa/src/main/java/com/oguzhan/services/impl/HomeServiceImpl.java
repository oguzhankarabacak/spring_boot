package com.oguzhan.services.impl;

import com.oguzhan.dto.DtoHome;
import com.oguzhan.dto.DtoRoom;
import com.oguzhan.entities.Home;
import com.oguzhan.entities.Room;
import com.oguzhan.repository.IHomeRepository;
import com.oguzhan.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {
    @Autowired
    IHomeRepository homeRepository;

    @Override
    public DtoHome getHomeById(Long id) {
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isPresent()){
            Home home = optional.get();
            List<Room> roomList = home.getRooms();

            DtoHome dtoHome = new DtoHome();
            List<DtoRoom> dtoRoomList = new ArrayList<>();

            BeanUtils.copyProperties(home,dtoHome);

            for (Room room : roomList){
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoRoomList.add(dtoRoom);
            }
            dtoHome.setRoomList(dtoRoomList);
            return dtoHome;
        }
        return null;

    }
}
