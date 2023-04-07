package pojo.create.team;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
public class CreateTeamRequestBody {

    private String name;
    private String shortName;
    private String description;
    private String logo;
    private String banner;
    private String teamPrimaryColor;
    private String  teamSecondaryColor;
    private String teamCity;
    private Location location;

@Getter
public static class Location
{
    @Setter
    private  String placeId;
    private  double latitude;
    private  double longitude;
    private  String address;
    public Location(String placeId, double latitude, double longitude, String address)
    {
    this.placeId = placeId;
    this.latitude = latitude;
    this.longitude = longitude;
    this.address = address;
  }
}

    public CreateTeamRequestBody(Builder builder) {
        this.name=builder.name;
        this.shortName=builder.shortName;
        this.description=builder.description;
        this.logo=builder.logo;
        this.banner=builder.banner;
        this.teamPrimaryColor=builder.teamPrimaryColor;
        this.teamSecondaryColor=builder.teamSecondaryColor;
        this.teamCity=builder.teamCity;
        this.location=builder.location;
}
public static class Builder {
        private String name;
        private String shortName;
        private String description;
        private String logo;
        private String banner;
        private String teamPrimaryColor;
        private String  teamSecondaryColor;
        private String teamCity;
        private Location location;

        public Builder()
        {
       this.name= Faker.instance(new Locale("en_IND")).team().name();
       this.shortName=name.charAt(0)+""+name.charAt(3)+""+name.charAt(5);
       this.description= Faker.instance(new Locale("en_IND")).lorem().characters();
       this.logo=Faker.instance().internet().avatar();
       this.banner=Faker.instance().internet().image();
        this.teamPrimaryColor=Faker.instance().color().hex();
        this.teamSecondaryColor=Faker.instance().color().hex();
        this.teamCity= Faker.instance(new Locale("en_IND")).address().city();

        }
        public Builder setLocation(String placeId, double latitude, double longitude, String address) {
            this.location = new Location(placeId, latitude, longitude, address);
            return this;
        }


        public CreateTeamRequestBody  build() {
            CreateTeamRequestBody    createTeamRequestBody = new CreateTeamRequestBody(this);

            return createTeamRequestBody;

        }


    }
}



