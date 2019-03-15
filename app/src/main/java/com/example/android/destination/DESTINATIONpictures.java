package com.example.android.destination;

public class DESTINATIONpictures {
    public static String getPicturesUrl(String destination) {
        String url;
        switch (destination.toLowerCase()) {
            case"rome": url="http://farm3.staticflickr.com/2864/33021306213_50db4d0831_b.jpg";break;
            case"london": url="https://farm4.staticflickr.com/3840/33835521225_d0601b1f2f_b.jpg";break;
            case"las vegas": url="https://farm4.staticflickr.com/3835/33679768402_5dc0f64dc4_b.jpg";break;
            case"japan": url="https://farm3.staticflickr.com/2856/33679616332_6614f058b0_b.jpg";break;
            case"vancouver": url="https://farm3.staticflickr.com/2889/33021175543_46b56c37e9_b.jpg";break;
            case"california": url="https://farm3.staticflickr.com/2870/33679616692_6d303d66ce_b.jpg";break;
            case"rio de janeiro": url="https://farm3.staticflickr.com/2819/32992159794_715b199f05_b.jpg";break;
            case"mexico": url="https://farm4.staticflickr.com/3853/33679615882_f374f5175d_b.jpg";break;
            case"egypt": url="https://farm3.staticflickr.com/2805/33450797030_58c86e6c86_b.jpg";break;
            case"new york": url="https://farm3.staticflickr.com/2871/33706858111_cf95c297f9_b.jpg";break;
            case"miami": url="https://farm4.staticflickr.com/3852/33706858601_5f5f405c4f_b.jpg";break;
            case"yellowstone": url="https://farm3.staticflickr.com/2913/33706857401_c1cd861467_b.jpg";break;
            case"washington": url="https://farm3.staticflickr.com/2950/33706857551_7de368e59f_b.jpg";break;
            case"paris": url="https://farm3.staticflickr.com/2919/33710699591_e7542dacc7_b.jpg";break;
            case"lisbon": url="https://farm3.staticflickr.com/2825/33839891505_d9190c5eed_b.jpg";break;
            case"athens": url="https://farm3.staticflickr.com/2872/33710698661_ebf46e0934_b.jpg";break;
            case"mykonos": url="https://farm4.staticflickr.com/3948/33839891025_8e30c442ee_b.jpg";break;
            case"tuscany": url="https://farm4.staticflickr.com/3949/33839888795_42c3d5ae63_b.jpg";break;
            case"india": url="https://farm4.staticflickr.com/3938/33710700691_b4e03380bf_b.jpg";break;
            case"bali": url="https://farm4.staticflickr.com/3951/33041828473_e0eebc750b_b.jpg";break;
            case"dubai": url="https://farm4.staticflickr.com/3871/33839889465_e4844024ca_b.jpg";break;
            case"hong kong": url="https://farm4.staticflickr.com/3954/33839891865_fd8bb5cfd3_b.jpg";break;
            case"moscow": url="https://farm3.staticflickr.com/2816/33710700191_5ffd1908dc_b.jpg";break;
            case"south africa": url="https://farm3.staticflickr.com/2884/33839890325_7aec24ac67_b.jpg";break;
            case"dakar": url="https://farm3.staticflickr.com/2950/33710701291_4665ea266a_b.jpg";break;
            case"madagascar": url="https://farm3.staticflickr.com/2806/33710697971_b21f515bfa_b.jpg";break;
            default:url="https://pbs.twimg.com/profile_images/648191420218646529/-RueAdXr_400x400.jpg";
        }
        return url;
    }
}

