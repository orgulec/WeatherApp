package api.weatherbit;


class CityWbResponse {

    public DataWbElement[] data;

    public CityWbResponse(DataWbElement[] data) {
        this.data = data;
    }

}

/*
count	1
data
0
    app_temp	-1.9
    aqi	52
    city_name	"Warsaw"    ////
    clouds	86  ///
    country_code	"PL"
    datetime	"2023-11-25:22"
    dewpt	-0.1
    dhi	0
    dni	0
    elev_angle	-58.46
    ghi	0
    gust	7.72
    h_angle	-90
    lat	52.22977
    lon	21.01178
    ob_time	"2023-11-25 22:07"
    pod	"n"
    precip	0
    pres	988
    rh	87
    slp	1001
    snow	0
    solar_rad	0
    sources
    0	"analysis"
    1	"E5546"
    2	"radar"
    3	"satellite"
    state_code	"78"
    station	"E5546"
    sunrise	"06:14"
    sunset	"14:31"
    temp	2.2
    timezone	"Europe/Warsaw"
    ts	1700950040
    uv	0
    vis	16
    weather
    description	"Broken clouds"
    code	803
    icon	"c03n"
    wind_cdir	"W"
    wind_cdir_full	"west"
    wind_dir	275
    wind_spd	4.63
 */