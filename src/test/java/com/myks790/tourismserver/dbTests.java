package com.myks790.tourismserver;

import com.myks790.tourismserver.model.*;
import com.myks790.tourismserver.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class dbTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Rollback(value = false)
    public void insertAll(){
        insertUser();
        insertCategory();
        insertPlace();
        insertPlan();
        insertRoute();
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

    public void insertRoute(){
        String datas[] = {
                "1	한라산	1	1	힘들겠다",
                "1	제주동문시장	1	2	맛있겠다",
                "1	넥슨컴퓨터박물관	2	1",
                "1	메이즈랜드	2	2",
                "1	테지움 제주	3	1",
                "2	월정리해변	1	1",
                "2	제주동문시장	1	2	시장하구나 시장을가자",
                "2	제주 절물 자연 휴양림	2	1",
                "3	한라산	1	1",
                "3	월정리해변	2	1",
                "4	제주동문시장	1	1",
                "4	생각하는 정원	2	1",
                "4	제주불빛정원	2	2",
                "4	월정리 해변	2	3	카페카페",
                "4	제주시 민속 오일시장	3	1",
                "4	넥슨컴퓨터박물관	3	2",
                "5	테지움 제주	1	1",
                "5	제주동문시장	1	2",
                "6	월정리해변	1	1",
                "6	넥슨컴퓨터박물관	1	2",
                "6	한라산	2	1",
                "6	제주시 민속 오일시장	3	1",
                "6	제주불빛정원	3	2",
                "6	메이즈랜드	3	3",
                "6	테지움 제주	4	1",
                "6	생각하는 정원	4	2",
        };
        for (String data : datas){
            String[] d = data.split("	");
            Route route = new Route();
            route.setPlan(planRepository.findById(Integer.valueOf(d[0])).get());
            route.setPlace(placeRepository.findByName(d[1]));
            route.setDay(Integer.valueOf(d[2]));
            route.setRouteOrder(Integer.valueOf(d[3]));
            if(d.length == 5)
                route.setDescription(d[4]);
            routeRepository.save(route);
        }
    }

    public void insertPlan(){
        String datas[] = {
                //회원 id 제목	                기간 태그 일정번호 공유수 추천수 공유판단
                "guest	원범이와 함께하는 힐링 여행	3	카페	1	52	17	1",
                "guest1	재희의 힐링 여행기	2	힐링	2	48	22	1",
                "guest2	혜린네 가족여행	2	관광	3	0	0	0",
                "오현규	2명이 가면 3명이 되어서 돌아오는 제주 여행	3	힐링	4	3	7	1",
                "guest4	아이돌 강재희의 제주 투어 코스	1	카페	5	17	9	1",
                "guest	제주 정복 가즈아	4	오름	6	3	6	1",
                "guest5	3일 여행	3	바다	7	5	14	1",
                "guest1	제주로의 우정 여행	3	관광	8	0	0	0",
                "guest2	연예인 제주 투어 코스	1	카페	9	63	41	1",
                "guest4	제주도 2일 정복	2	관광	10	0	0	0"
        };
        for (String data : datas){
            String[] d = data.split("	");
            Plan plan = new Plan();
            plan.setUser(userRepository.findByName(d[0]));
            plan.setTitle(d[1]);
            plan.setPeriod(Integer.valueOf(d[2]));
            List list = new ArrayList();
            list.add(categoryRepository.findByTitle(d[3]));
            plan.setCategories(list);
            plan.setNumberOfShares(Integer.valueOf(d[5]));
            plan.setNumberOfRecommendation(Integer.valueOf(d[6]));
            plan.setShared(Boolean.valueOf(d[7]));
            plan.setOriginalPlan(plan);

            planRepository.save(plan);
        }
    }

}
