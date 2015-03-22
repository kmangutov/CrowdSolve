package com.kmangutov.crowdsolve.services;

import com.kmangutov.crowdsolve.models.IdWrapper;
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
    private static final String QUESTION_SERVER_URL = "http://10.0.3.2:3000/api";

    public QuestionsApi mApi;


    private static QuestionService mInstance;
    public static QuestionService getInstance() {

        if(mInstance == null)
            mInstance = new QuestionService();
        return mInstance;
    }

    protected QuestionService() {

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

        @GET("/questions")
        public Observable<List<Question>> getQuestions();

        @GET("/questions/{id}")
        public Observable<Question> getQuestion(@Path("id") int id);

        @POST("/questions")
        public Observable<ServerResponse> postQuestion(@Body Question question);

        @POST("/users")
        public Observable<ServerResponse> register(@Body User user);

        @POST("/log-in")
        public Observable<ServerResponse> login(@Body User user);

        @GET("/getuid")
        public Observable<IdWrapper> getUid(@Body User user);
    }
}
