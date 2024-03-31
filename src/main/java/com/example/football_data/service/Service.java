import com.example.football_data.model.Standings;
import com.example.football_data.model.Team;
import com.example.football_data.service.FootballDataAPI;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private String BASE_URL = "https://api.football-data.org";
    private FootballDataAPI footballDataAPI;

    public Service() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        this.footballDataAPI = retrofit.create(FootballDataAPI.class);
    }

    public Observable<Team> getStandings(String competition){
        return this.footballDataAPI.getStandings(competition).flatMapIterable(standings->standings)
                .map(standings->standings.getTables()).flatMapIterable(tables->tables)
                .map(tables->tables.getTeam());
    }


}

