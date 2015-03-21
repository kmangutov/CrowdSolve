package com.kmangutov.crowdsolve.services;

import com.kmangutov.crowdsolve.models.Question;
import com.kmangutov.crowdsolve.models.ServerResponse;
import com.kmangutov.crowdsolve.models.User;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by kmangutov on 3/21/15.
 */
public class QuestionService {

    //private static final String QUESTION_SERVER_URL = "http://localhost:3000/api";
    //private static final String QUESTION_SERVER_URL = "http://10.0.3.2:3000/api";

    private static final String QUESTION_SERVER_URL = "http://97e526f.ngrok.com";

    public QuestionsApi mApi;

    public QuestionService() {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(QUESTION_SERVER_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mApi = restAdapter.create(QuestionsApi.class);
    }

    public interface QuestionsApi {

        @GET("/question")
        public Observable<List<Question>> getQuestions();

        @GET("/question/{id}")
        public Observable<Question> getQuestion(@Path("id") int id);

        @POST("/users")
        public Observable<ServerResponse> register(@Body User user);

        @POST("/log-in")
        public Observable<ServerResponse> login(@Body User user);
    }
}
