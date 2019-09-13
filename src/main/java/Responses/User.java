package Responses;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }

    private class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode=" + zipcode +
                    ", geo=" + geo +
                    '}';
        }

        private class Geo {
            private double lat;
            private double lng;

            @Override
            public String toString() {
                return "Geo{" +
                        "lat=" + lat +
                        ", lng=" + lng +
                        '}';
            }
        }
    }

    private class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }
}
