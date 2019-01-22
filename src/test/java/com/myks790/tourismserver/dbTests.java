package com.myks790.tourismserver;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.model.Place;
import com.myks790.tourismserver.model.PlaceCategory;
import com.myks790.tourismserver.model.User;
import com.myks790.tourismserver.repository.CategoryRepository;
import com.myks790.tourismserver.repository.PlaceRepository;
import com.myks790.tourismserver.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class dbTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Rollback(value = false)
    public void insertAll(){
        insertUser();
        insertCategory();
        insertPlace();
    }

    public void insertUser() {
        String names[] = {"guest","guest1","guest2","guest3","guest4","guest5","오현규"};
        for (String name : names){
            User user = new User();
            user.setName(name);
            userRepository.save(user);
        }
    }

    public void insertCategory() {
        String titles[] = {"힐링","자연","관광","카페","오름","바다","먹방"};
        for (String cate : titles){
            Category category = new Category();
            category.setTitle(cate);
            categoryRepository.save(category);
        }
    }

    public void insertPlace() {
        String datas[][] = {
                {"한라산", "", "백록담 : 제주특별자치도 서귀포 토평동 산 15번지", "해발 : 1,950m", "TOURIST_SPOTS"},
                {"넥슨컴퓨터박물관","https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EB%84%A5%EC%8A%A8%EC%BB%B4%ED%93%A8%ED%84%B0%EB%B0%95%EB%AC%BC%EA%B4%80.jpg", "제주 1100로 3198-8 NXC센터 (우) 63091", "메가티켓 - 성인:8,000원 청소년:6,000원 어린이:12,000원 / 기가티켓 - 성인:12,000원 / 테라티켓 - 성인2+어린이2:25,000원", "TOURIST_SPOTS"},
                {"제주동문시장", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%EB%8F%99%EB%AC%B8%EC%8B%9C%EC%9E%A5.jpg", "제주 이도1동 1329-6", "개장시간 : 오전 5:00 - 오후 8:00", "TOURIST_SPOTS"},
                {"메이즈랜드", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EB%A9%94%EC%9D%B4%EC%A6%88%EB%9E%9C%EB%93%9C.jpg", "제주 구좌읍 비자림로 2134-47 (우) 63351", "성인:11,000원 청소년/군인:8,000원 어린이/경로/유공자:8,000원 장애인:5,000원", "TOURIST_SPOTS"},
                {"월정리해변", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%9B%94%EC%A0%95%EB%A6%AC%ED%95%B4%EB%B3%80.jpg", "제주 구좌읍 월정리 33-3", "", "TOURIST_SPOTS"},
                {"제주불빛정원", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%EB%B6%88%EB%B9%9B%EC%A0%95%EC%9B%90.jpg", "제주 애월읍 평화로 2346 (우) 63066", "일반:12,000원 (SNS 인증시 10% 할인) 어린이/제주도민/장애인/노인:8,000원 (신분증 제시, 단체 10% 할인)", "TOURIST_SPOTS"},
                {"테지움 제주", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%ED%85%8C%EC%A7%80%EC%9B%80%20%EC%A0%9C%EC%A3%BC.jpg", "제주 애월읍 평화로 2159 (우) 695-910", "성인:10,000원 군경/장애인/경로:8,000원 청소년:9,000원 어린이:8,000원 만36개월:무료", "TOURIST_SPOTS"},
                {"제주시 민속 오일시장", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%EC%8B%9C%20%EB%AF%BC%EC%86%8D%20%EC%98%A4%EC%9D%BC%EC%8B%9C%EC%9E%A5.jpg", "제주 오일장서길 26 (우) 63116", "매 2일, 7일날 열림", "TOURIST_SPOTS"},
                {"제주 절물 자연 휴양림", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%20%EC%A0%88%EB%AC%BC%20%EC%9E%90%EC%97%B0%20%ED%9C%B4%EC%96%91%EB%A6%BC.jpg", "위치 : 제주특별자치도 제주시 명림로 584", "일반:1,000원 청소년 600원 어린이 300원", "TOURIST_SPOTS"},
                {"생각하는 정원", "https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%83%9D%EA%B0%81%ED%95%98%EB%8A%94%20%EC%A0%95%EC%9B%90.jpg", "제주 한경면 저지리 1534 (우) 695-947", "성인:12,000원 청소년:10,000원 경로:10,000원 어린이:7,000원", "TOURIST_SPOTS"}
        };
        for (String[] data : datas){
            Place place = new Place();
            place.setName(data[0]);
            place.setImageUrl(data[1]);
            place.setLocation(data[2]);
            place.setInformation(data[3]);
            place.setPlaceCategory(PlaceCategory.valueOf(data[4]));
            placeRepository.save(place);
        }
    }


}
