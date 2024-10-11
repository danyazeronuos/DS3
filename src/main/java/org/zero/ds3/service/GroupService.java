package org.zero.ds3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zero.ds3.model.GroupCreationDTO;
import org.zero.ds3.repository.CityRepository;
import org.zero.ds3.repository.GroupRepository;
import org.zero.ds3.repository.ResidentRepository;
import org.zero.ds3.utils.CreateGroupDialog;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final CityRepository cityRepository;
    private final GroupRepository groupRepository;
    private final ResidentRepository residentRepository;

    public void createGroup() {
        var dialogConstructor = new CreateGroupDialog(this.getGroupCreationDTO());
        var newGroup = dialogConstructor.init("Create Group");
        newGroup.ifPresent(groupRepository::save);
    }

    private GroupCreationDTO getGroupCreationDTO() {
        return new GroupCreationDTO(
                cityRepository.findAll(),
                residentRepository.findAll()
        );
    }
}

