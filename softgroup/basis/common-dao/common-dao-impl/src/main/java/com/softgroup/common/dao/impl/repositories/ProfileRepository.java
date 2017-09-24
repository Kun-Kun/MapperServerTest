package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Odin on 03.03.2017.
 */
public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity, String> {

    List<ProfileEntity> findByName(String s);

    List<ProfileEntity> findByNameAndPhoneNumber(String s, String number);

    ProfileEntity findByPhoneNumber(String number);

    @Query(nativeQuery = true, value =  "SELECT prof.* FROM messenger.profiles prof JOIN messenger.conversation_members conmem ON conmem.member_id= prof.id WHERE conmem.conversation_id = :conversationId")
    List<ProfileEntity> findByConversationId(@Param(value = "conversationId") String conversationId);

}
