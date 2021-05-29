package com.azurealstn.codespringweb.sample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@Getter
//@AllArgsConstructor //모든 파라미터를 받는 생성자를 생성해줌
@RequiredArgsConstructor
public class SampleHotel {

    private final Chef chef; //final이 붙은 인스턴스에 대한 생성자를 만들어줌

    //생성자 주입
//    public SampleHotel(Chef chef) {
//        this.chef = chef;
//    }
}
