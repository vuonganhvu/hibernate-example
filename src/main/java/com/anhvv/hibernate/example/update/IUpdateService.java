package com.anhvv.hibernate.example.update;

public interface IUpdateService {

    void updateNotFindId(Long id, SchoolUpdateReq schoolUpdateReq);

    void updateFindId(Long id, SchoolUpdateReq schoolUpdateReq);
}
