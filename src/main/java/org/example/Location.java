package org.example;

public class Location {

    private String country;

    private String city;
    private String address;
    private Double latitude;
    private Double longitude;

    private Location (Builder builder) {
        this.city = builder.city;
        this.address = builder.address;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public static class Builder {
        private String country;

        private String city;
        private String address;
        private Double latitude;
        private Double longitude;

        public Builder(String country) {
            if (country.isBlank())
                throw new LocationException("LocationException: Country is missing.");
            else
                this.country = country;
        }
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setLatitude(String latitude) {
            if (latitude.isBlank())
                this.latitude = null;
            else
                this.latitude = Double.parseDouble(latitude.trim());
            return this;
        }
        public Builder setLongitude(String longitude) {
            if (longitude.isBlank())
                this.longitude = null;
            else
                this.longitude = Double.parseDouble(longitude.trim());
            return this;
        }
        public Location build() {
            return new Location(this);
        }
    }
}
