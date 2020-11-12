package com.example.coronavirus.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirus.R;
import com.example.coronavirus.restclient.dto.News;
import com.example.coronavirus.ui.adapter.NewsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoronaNews extends AppCompatActivity {
    final static String TAG = CoronaNews.class.getSimpleName();

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_news);
        setTitle("코로나 뉴스");
        ButterKnife.bind(this);

        init();
    }

    void init(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvNews.setLayoutManager(linearLayoutManager);

        newsAdapter = new NewsAdapter();
        rvNews.setAdapter(newsAdapter);

        newsAdapter.setData(getNewsData());
    }

    ArrayList<News> getNewsData(){
        ArrayList<News> newsList = new ArrayList<>();
        newsList.add(new News(
                "세계 코로나19 확진 5천만명…\"몇달간 바이러스 쓰나미\"",
                "전 세계 신종 코로나바이러스 감염증(코로나19) 누적 확진자가 5천만 명을 넘어섰다.\n" +
                        "\n" +
                        "글로벌 확산세가 점점 가팔라지는 추세가 감지되는 가운데 전문가들은 앞으로 몇 달 동안 '바이러스의 쓰나미'가 닥칠 것이라고 경고하고 있다.",
                R.drawable.news1
        ));
        newsList.add(new News(
             "감염 안 돼도 코로나19 반응하는 항체 있다",
             "코로나19에 감염되지 않았어도 바이러스에 반응하는 항체를 지닌 사람들이 있다는 연구 결과가 나와 주목된다.\n" +
                     "영국 프랜시스 크릭 연구소(Francis Crick Institute) 레트로바이러스 면역학 연구실장 구게오그레 카시오티스 박사 연구팀은 소수의 성인과 특히 아이들은 코로나19 바이러스에 교차 반응(cross reaction)을 보이는 항체를 지니고 있다는 연구 결과를 발표했다고 사이언스 데일리가 7일 보도했다.",
                R.drawable.news2jpg
        ));
        newsList.add(new News(
                "대기 600통에 울렁”…코로나발 문의 폭주에 상담사들 '탈진'",
                "(코로나19) 지원금 관련 뉴스가 방송에 나오면 최고 600명까지 올라갑니다.” 정부민원안내콜센터(110콜센터) 상담사의 업무용 피시(PC) 모니터 왼쪽 상단에는 ‘대기 고객’이 초 단위로 올라간다. 600명은 대기 고객 숫자다. 이아무개(33)씨는 지난해 10월부터 110콜센터의 민간위탁업체인 한국코퍼레이션에서 상담사로 일하다 올여름 ‘기능성 발성장애’(목소리가 갑자기 끊기거나 떨리는 증상) 진단을 받았다. 코로나19 관련 지원금 문의 전화 폭주에 쉴 새 없이 대응하다 얻은 질병이다. 이씨는 결국 올해 7월 근로복지공단에 산업재해를 신청했다.\n",
                R.drawable.news3jpg
        ));
        return newsList;
    }

}
