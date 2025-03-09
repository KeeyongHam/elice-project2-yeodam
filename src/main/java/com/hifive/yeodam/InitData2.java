package com.hifive.yeodam;

import com.hifive.yeodam.auth.entity.Auth;
import com.hifive.yeodam.auth.entity.RoleType;
import com.hifive.yeodam.category.entity.Category;
import com.hifive.yeodam.seller.entity.Guide;
import com.hifive.yeodam.seller.entity.Seller;
import com.hifive.yeodam.tour.entity.Tour;
import com.hifive.yeodam.tour.entity.TourGuide;
import com.hifive.yeodam.user.entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/* 테스트용 더미 데이터 추후 삭제 예정*/
//@Component
@RequiredArgsConstructor
public class InitData2 {

    private final InitUser initUser;
    private final InitUser.InitItem initItem;

    @PostConstruct
    public void init() {
        initUser.initDb();
        initItem.initDb();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitUser {

        private final EntityManager em;
        private final PasswordEncoder passwordEncoder;

        public void initDb() {
            Auth auth = Auth.builder()
                    .email("123@a.com")
                    .role(RoleType.USER)
                    .password(passwordEncoder.encode("1234"))
                    .build();

            em.persist(auth);

            User user = User.builder()
                    .name("홍길동")
                    .nickname("길동이")
                    .phone("1234-1234")
                    .auth(auth)
                    .build();

            em.persist(user);
        }

        @Component
        @Transactional
        @RequiredArgsConstructor
        static class InitItem {

            private final EntityManager em;
            private final PasswordEncoder passwordEncoder;

            public void initDb() {
                Auth auth = Auth.builder()
                        .email("1234@a.com")
                        .role(RoleType.SELLER)
                        .password(passwordEncoder.encode("1234"))
                        .build();

                em.persist(auth);

                Seller seller = Seller.builder()
                        .auth(auth)
                        .companyName("회사1")
                        .build();

                em.persist(seller);

                Guide guideA = Guide.builder()
                        .bio("ㅎㅇ")
                        .birth(LocalDate.now())
                        .name("가이드1")
                        .seller(seller)
                        .build();

                Guide guideB = Guide.builder()
                        .bio("ㅎㅇ")
                        .birth(LocalDate.now())
                        .name("가이드2")
                        .seller(seller)
                        .build();

                em.persist(guideA);
                em.persist(guideB);

                Tour tour = Tour.builder()
                        .itemName("제주도 푸른밤")
                        .price(100)
                        .seller(seller)
                        .stock(1)
                        .maximum(1)
                        .active(true)
                        .build();

                em.persist(tour);

                TourGuide tourGuide = TourGuide.builder()
                        .guide(guideA)
                        .tour(tour)
                        .build();

                em.persist(tourGuide);

                Category category = Category.builder()
                        .name("힐링").build();

                em.persist(category);
            }
        }
    }
}
