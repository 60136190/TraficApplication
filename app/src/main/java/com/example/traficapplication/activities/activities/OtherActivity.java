package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.LawAdapter;
import com.example.traficapplication.activities.models.Law;

import java.util.ArrayList;

public class OtherActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LawAdapter lawAdapter;
    private ArrayList<Law> law = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initUi();
        setRecylerView();

    }



    private void defineItem() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b.get("lawPos").equals("0")) {
            cmd_guiding();
        }
        if (b.get("lawPos").equals("1")) {
            change_direct();
        }
        if (b.get("lawPos").equals("2")){
            stop_park();

        }
        if (b.get("lawPos").equals("3")){
            horn();
        }
        if (b.get("lawPos").equals("4")){
            speed_space();

        }
        if (b.get("lawPos").equals("5")){
            delivery();
        }
        if (b.get("lawPos").equals("6")){
            equipment_vehicle();
        }
        if (b.get("lawPos").equals("7")){
            one_way();
        }
        if (b.get("lawPos").equals("8")){
            alcohol();
        }
        if (b.get("lawPos").equals("9")){
            document();
        }
        if (b.get("lawPos").equals("10")){
            other();
        }


    }

    private void other() {
        itemAdd(R.drawable.img,"Đi dàn hàng ngang từ 3 (ba) xe trở lên","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Đi dàn hàng ngang từ 2 (2) xe trở lên","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Sửa dụng ô (dù), điện thoại di động khi lái xe","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Chở người ngồi trên xe đạp, xe đạp máy sử dụng ô (dù)","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Dùng xe đẩy làm quầy hàng lưu động trên đường gây cản trở giao thông.","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe đạp, xe đạp máy buông cả hai tay","Phạt tiền từ 100.000 đồng đến 200.000 đồng","");
        itemAdd(R.drawable.img,"Dùng chân điều khiển xe đạp, xe đạp máy","Phạt tiền từ 100.000 đồng đến 200.000 đồng","");
        itemAdd(R.drawable.img,"Đang điều khiển xe hoặc chở người ngồi trên xe bám, kéo, đẩy xe khác, vật khác, mang vác vật cồng kềnh","Phạt tiền từ 100.000 đồng đến 200.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe kéo theo xe khác, vật khác","Phạt tiền từ 100.000 đồng đến 200.000 đồng","");
        itemAdd(R.drawable.img,"Ngồi trên xe bám, kéo, đẩy xe khác, vật khác, mang vác vật cồng kềnh","Phạt tiền từ 100.000 đồng đến 200.000 đồng","");

    }

    private void document() {
        itemAdd(R.drawable.img,"Điều khiển xe có Giấy chứng nhận hoặc tem kiểm định an toàn kỹ thuật và bảo vệ môi trường nhưng đã hết hạn sử dụng dưới 1 tháng ( kể cả rơ moóc)","Phạt tiền từ 300.000 đồng đến 400.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe không có Giấy chứng nhận hoặc tem kiểm định an toàn kỹ thuật và bảo vệ môi trường hoặc có nhưng đã hết hạn sử dụng từ 1 tháng trở lên ( kể cả rơ moóc)","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng","");
        itemAdd(R.drawable.img,"Sử dụng Giấy đăng ký xe, Giấy chứng nhận tem kiểm định an toàn kỹ thuật và bảo vệ môi trường không do cơ quan có thẩm quyền cấp hoặc đã bị tẩy xóa","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng","");
        itemAdd(R.drawable.img,"Không mang theo Giấy phép lái xe","Phạt tiền từ 200.000 đồng đến 400.000 đồng","");
        itemAdd(R.drawable.img,"Không mang theo Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường (đối với loại xe có quy định phải kiểm định, kể cả rơ moóc và sơ mi rơ moóc.","Phạt tiền từ 400.000 đồng đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Không có hoặc không mang theo Giấy chứng nhận bảo hiểm trách nhiệm dân sự của chủ xe cơ giới còn hiệu lực","Phạt tiền từ 400.000 đồng đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Có Giấy phép lái xe nhưng đã hết hạn sử dụng dưới 6 tháng.","Phạt tiền từ 400.000 đồng đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Có Giấy phép lái xe nhưng không phù hợp với loại xe đang điều khiển hoặc đã hết hạn sử dụng từ 6 tháng trở lên","Phạt tiền từ 4.000.000 đồng đến 6.000.000 đồng","");
        itemAdd(R.drawable.img,"Không có Giấy phép lái xe hoặc sử dụng Giấy phép lái xe không do cơ quan có thẩm quyền cấp, Giấy phép lái xe bị tẩy xóa.","Phạt tiền từ 4.000.000 đồng đến 6.000.000 đồng","");
        itemAdd(R.drawable.img,"Sử dụng Giấy phép lái xe không hợp lệ ( Giấy phép lái xe có số phôi ghi ở mặt sau không trùng với số phôi được cấp mới nhất trong hệ thống thông tin quản lý Giấy phép lái xe)","Phạt tiền từ 4.000.000 đồng đến 6.000.000 đồng","");
    }

    private void alcohol() {
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn nhưng chưa vượt quá 50 miligam/100 mililít máu hoặc chưa vượt quá 0,25 miligam/1 lít khí thở","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 50 miligam đến 80 miligam/100 mililít máu hoặc vượt quá 0,25 miligam đến 0,4 miligam/1 lít khí thở","Phạt tiền từ 200.000 đồng đến 300.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 80 miligam/100 mililít máu hoặc vượt quá 0,4 miligam/1 lít khí thở.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","");
        itemAdd(R.drawable.img,"Không chấp hành yêu cầu kiểm tra về nồng độ cồn của người thi hành công vụ.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn nhưng chưa vượt quá 50 miligam/100 mililít máu hoặc chưa vượt quá 0,25 miligam/1 lít khí thở","Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 50 miligam đến 80 miligam/100 mililít máu hoặc vượt quá 0,25 miligam đến 0,4 miligam/1 lít khí thở.","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 80 miligam/100 mililít máu hoặc vượt quá 0,4 miligam/1 lít khí thở.","Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng.","");
        itemAdd(R.drawable.img,"Không chấp hành yêu cầu kiểm tra về nồng độ cồn của người thi hành công vụ.","Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe trên đường mà trong cơ thể có chất ma túy","Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng.","");
        itemAdd(R.drawable.img,"Không chấp hành yêu cầu kiểm tra về chất ma túy của người thi hành công vụ.","Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng","");
    }

    private void one_way() {
        itemAdd(R.drawable.img,"Đi vào khu vực cấm","Phạt tiền từ 200.000 đến 300.000 đồng","");
        itemAdd(R.drawable.img,"Đi vào đường có biển báo hiệu nội dung cấm đi vào đối với loại phương tiện đang điều khiển","Phạt tiền từ 200.000 đến 300.000 đồng","");
        itemAdd(R.drawable.img,"Đi ngược chiều của đường một chiều, đường có biển báo cấm đi ngược chiều","Phạt tiền từ 200.000 đến 300.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe đi vào đường cao tốc","Phạt tiền từ 400.000 đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Đi vào khu vực cấm, đường có biển báo hiệu có nội dụng cấm đi vào đối với loại phương tiện đang điều khiển","Phạt tiền từ 400.000 đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Không đi bên phải theo chiều đi của mình","Phạt tiền từ 400.000 đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Không đi đúng phần đường hoặc làn đường quy định (làn cùng chiều hoặc làn ngược chiều)","Phạt tiền từ 400.000 đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe đi qua dải phân cách cố định ở giữa hai phần đường xe chạy","Phạt tiền từ 400.000 đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Đi vào đường cao tốc","Phạt tiền từ 100.000 đến 200.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển, dẫn dắt súc vật đi không đúng phần đường quy định, đi vào đường cấm, khu vực cấm, đi vào phần đường của xe cơ giới","Phạt tiền từ 60.000 đến 100.000 đồng","");

    }

    private void equipment_vehicle() {
        itemAdd(R.drawable.img,"Chạy trong hầm đường bộ không có đèn hoặc vật phát sáng báo hiệu","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe thô sơ đi ban đêm không có đèn báo hiệu ằng đẹn hoặc vật phản quang","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Xe không có hệ thống hãm hoặc có nhưng kông có tác dụng","Phạt tiền từ 200.000 đồng đến 300.000 đồng","");
        itemAdd(R.drawable.img,"Không sử dụng hoặc sử dụng không đủ đèn chiếu sáng trong thời gian từ 19 giờ ngày hôm trước đến 5 giờ ngày hôm sau, khi sương mù, thời tiết xấu hạn chế tầm nhìn","Phạt tiền từ 400.000 đồng đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Sử dụng đèn chiếu xa khi tránh đi xe ngược chiều","Phạt tiền từ 400.000 đồng đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Chạy xe trong hầm đường bộ không sử dụng đèn chiếu sáng","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe gắn biển số không đúng vị trí","Phạt tiền từ 300.000 đồng đến 400.000 đồng","");
        itemAdd(R.drawable.img,"Gắn biển số không rõ chữ","Phạt tiền từ 300.000 đồng đến 400.000 đồng","");
        itemAdd(R.drawable.img,"Gắn biển số bị che lấp, bị cong, bị hỏng","Phạt tiền từ 300.000 đồng đến 400.000 đồng","");
        itemAdd(R.drawable.img,"Sơn, dán thêm làm thay đổi chữ, số hoặc thay đổi màu sắc của chữ số, nền biển","Phạt tiềnbiển300.000 đồng đến 400.000 đồng","");
    }

    private void delivery() {
        itemAdd(R.drawable.img,"Chở quá số người quy định","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","");
        itemAdd(R.drawable.img,"Xếp hàng hóa vượt quá giới hạn quy định, không bảo đảm an toàn, gây trở ngại giao thông, che khuất tầm nhìn của người điều khiển","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","");
        itemAdd(R.drawable.img," Mang, vác vật cồng kềnh gây cản trở giao thông","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","");
        itemAdd(R.drawable.img,"Xếp hàng hóa trên xe vượt quá giới hạn quy định","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","");
        itemAdd(R.drawable.img,"Chở hàng rời, chất thải, vật liệu xây dựng dễ rơi vãi mà không có mui, bạt che đậy hoặc có mui, bạt che đậy nhưng vẫn để rơi vãi","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng","");
        itemAdd(R.drawable.img,"Chở hàng hoặc chất thải để nước chảy xuống mặt đường gây mất an toàn giao thông và vệ sinh môi trường","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng.","");
        itemAdd(R.drawable.img,"Vận chuyển hàng trên xe phải chằng buộc mà không chằng buộc hoặc có chằng buộc nhưng không chắc chắn","Phạt tiền từ 600.000 đồng đến 800.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe xếp hàng trên nóc buồng lái, xếp hàng làm lệch xe","Phạt tiền từ 600.000 đồng đến 800.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe chở hàng vượt trọng tải (khối | lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 10% đến 30% (trừ xe xi téc chở chất lỏng), trên 20% đến 30% đối với xe xi téc chở chất lỏng","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","");
        itemAdd(R.drawable.img,"Chở hàng trên nóc thùng xe","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","");
        itemAdd(R.drawable.img,"Chở hàng vượt quá bề rộng thùng xe","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","");
        itemAdd(R.drawable.img,"Chở hàng vượt phía trước, phía sau thùng xe trên 10% chiều dài xe","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","");
        itemAdd(R.drawable.img,"Chở người trên thùng xe trái quy định","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","");
        itemAdd(R.drawable.img,"Để người nằm, ngồi trên mui xe, đu bám bên ngoài xe khi xe đang chạy","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","");
        itemAdd(R.drawable.img,"Vận chuyển hàng trên xe phải chằng buộc mà không chằng buộc hoặc có chăng buộc nhưng không chắc chắn gây tai nạn giao thông","Phạt tiền từ 8.000.000 đồng đến 12.000.000 đồng","");
        itemAdd(R.drawable.img,"Điều khiển xe xếp hàng trên nóc buồng lái, xếp hàng làm lệch xe gây tai nạn giao thông","Phạt tiền từ 8.000.000 đồng đến 12.000.000 đồng","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm | công, người đại diện điều khiển phương tiện Chở hành lý, hàng hóa vượt quá kích thước bao ngoài của xe","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển phương tiện chở hành lý, hàng hóa vượt quá kích thước bao ngoài của xe","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển phương tiện chở hành lý, hàng hóa vượt quá trọng tải theo thiết kế của xe","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển phương tiện chở hành lý, hàng hóa vượt quá kích thước bao ngoài của xe","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển phương tiện chở hành lý, hàng hóa vượt quá trọng tải theo thiết kể của xe","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển phương tiện chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 10% đến 30%","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 động đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển phương tiện chở hàng vượt quá chiều cao xếp hàng cho phép"," Phạt tiền từ 4.000.000 đồng đến 6.000.000 đồng đối với cá nhân, từ 8.000.000 đồng đến 12.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển phương tiện chở hàng vượt quá chiều cao xếp hàng cho phép","Phạt tiền từ 4.000.000 đồng đến 6.000.000 đồng đối với cá nhân, từ 8.000.000 đồng đến 12.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển phương tiện chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 30% đến 50%","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển phương tiện chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 30% đến 50%","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện chở hàng vượt khổ giới hạn của cầu, đường ghi trong Giấy phép lưu hành","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe vượt quá khổ giới hạn của cầu, đường hoặc chở hàng vượt khổ giới hạn của cầu, đường tham gia giao thông, trừ trường hợp có Giấy phép lưu hành còn giá trị sử dụng","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 20% đến 50%, trừ trường hợp có Giấy phép lưu hành còn giá trị sử dụng","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16,000,000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển phương tiện chở hàng vượt khổ giới hạn của cầu, đường ghi trong Giấy phép lưu hành","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe vượt quá khổ giới hạn của cầu, đường hoặc chở hàng vượt khổ giới hạn của cầu, đường tham gia giao thông, trừ trường hợp có Giấy phép lưu hành còn giá trị sử dụng"," Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 20% đến 50%, trừ trường hợp có Giấy phép lưu hành còn giá trị sử dụng","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng đối với cá nhân, từ 12.000.000 đồng đến 16.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 50% đến 100%","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe chở hàng siêu trường, siêu trọng không có Giấy phép lưu hành hoặc có Giấy phép lưu hành nhưng đã hết giá trị sử dụng hoặc sử dụng Giấy phép lưu hành không do cơ quan có thẩm quyền cấp","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe chở hàng siêu trường, siêu trọng không có giấy phép lưu hành hoặc có Giấy phép lưu hành nhưng đã hết giá trị sử dụng hoặc sử dụng Giấy phép lưu hành không do cơ quan có thẩm quyền cấp","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe Chở hàng siêu trường, siêu trọng có Giấy phép lưu hành còn giá trị sử dụng nhưng tổng trọng lượng, kích thước bao ngoài của xe (sau khi đã xếp hàng lên xe) vượt quá quy định trong Giấy phép lưu hành","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe Chở hàng siêu trường, siêu trọng có Giấy phép lưu hành còn giá trị sử dụng nhưng tổng trọng lượng, kích thước bao ngoài của xe (sau khi đã xếp hàng lên xe) vượt quá quy định trong Giấy phép lưu hành","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32,000,000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe chở hàng siêu trường, siêu trọng có Giấy phép lưu hành còn giá trị sử dụng nhưng đi không đúng tuyến đường quy định trong Giấy phép lưu hành"," Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe Chở hàng siêu trường, siêu trọng có Giấy phép lưu hành còn giá trị sử dụng nhưng đi không đúng tuyến đường quy định trong Giấy phép lưu hành","Phạt tiền từ 14,000,000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe Chở | hàng siêu trường, siêu trọng có Giấy phép lưu hành còn giá trị sử dụng nhưng chở không đúng loại hàng quy định trong Giấy phép lưu hành","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32,000,000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe Chở hàng siêu trường, siêu trọng có Giấy phép lưu hành còn giá trị sử dụng nhưng chở không đúng loại hàng quy định trong Giấy phép lưu hành","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 50% đến 100%","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 50% đến 100%","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng đối với cá nhân, từ 28.000.000 đồng đến 32.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 100% đến 150%","Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng đối với cá nhân, từ 32.000.000 đồng đến 36.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 100% đến 150%","Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng đối với cá nhân, từ 32.000.000 đồng đến 36.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 150%","Phạt tiền từ 18.000.000 đồng đến 20.000.000 | đồng đối với cá nhân, từ 36.000.000 đồng đến 40,000,000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 150%","Phạt tiền từ 18.000.000 đồng đến 20.000.000 đồng đối với cá nhân, từ 36.000.000 đồng đến 40.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe kéo theo rơ moóc, sơ mi rơ moóc mà khối lượng toàn bộ (bao gồm khối lượng bản thân rơ moóc, sơ mi rơ moóc và khối lượng hàng chuyên chở) của rơ moóc, sơ mi rơ moóc vượt khối lượng cho phép kéo theo được ghi trong giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 150%","Phạt tiền từ 18.000.000 đồng đến 20.000.000 đồng đối với cá nhân, từ 36.000.000 đồng đến 40.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe kéo theo rơ moóc, sơ mi rơ moóc mà khối lượng toàn bộ (bao gồm khối lượng bản thân rơ moóc, sơ mi rơ moóc và khối lượng hàng chuyên chở) của rơ moóc, sơ mi rơ moóc vượt khối lượng cho phép kéo theo được ghi trong giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 150%","Phạt tiền từ 18.000.000 đồng đến 20.000.000 đồng đối với cá nhân, từ 36.000.000 đồng đến 40.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 100% đến 150%","Phạt tiền từ 18.000.000 đồng đến 20.000.000 đồng đối với cá nhân, từ 36.000.000 đồng đến 40.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 100% đến 150%","Phạt tiền từ 18.000.000 đồng đến 20.000.000 đồng đối với cá nhân, từ 36.000.000 đồng đến 40.000.000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 150%","Phạt tiền từ 28.000.000 đồng đến 32.000.000 đồng đối với cá nhân, từ 56.000.000 đồng đến 64,000,000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Trực tiếp điều khiển xe mà tổng trọng lượng (khối lượng toàn bộ) của xe hoặc tải trọng trục xe (bao gồm cả hàng hóa xếp trên xe, người được chở trên xe) vượt quá tải trọng cho phép của cầu, đường trên 150%","Phạt tiền từ 28.000.000 đồng đến 32,000,000 đồng đối với cá nhân, từ 50.000.000 đồng đến 64,000,000 đồng đối với tổ chức","");
        itemAdd(R.drawable.img,"Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển xe kéo | theo rơ moóc, sơ mi rơ moóc mà khối lượng toàn bộ (bao gồm khối lượng bản thân rơ moóc, sơ mi rơ moóc và khối lượng hàng chuyên chở) của rơ moóc, sơ mi rơ moóc vượt khối lượng cho phép kéo theo được ghi trong giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 10% đến 30%","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000 đồng dối với tổ chức","");

    }

    private void speed_space() {
        itemAdd(R.drawable.img,"Điều khiển xe lạng lách, đánh võng.","Phạt tiền từ 200.000 đồng đến 300.000 đồng.","");
        itemAdd(R.drawable.img,"Đuổi nhau trên đường.","Phạt tiền từ 200.000 đồng đến 300.000 đồng.","");
        itemAdd(R.drawable.img,"Tụ tập để cổ vũ, kích động hành vi điều khiển xe chạy quá tốc độ quy định, lạng lách, đánh võng, đuổi nhau trên đường hoặc đua xe trái phép.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","");
        itemAdd(R.drawable.img,"Đua xe đạp, đua xe đạp máy, đua xe xích lô, đua xe súc vật kéo, cưỡi súc vật chạy đua trái phép trên đường giao thông.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","");
        itemAdd(R.drawable.img,"Chạy quá tốc độ quy định từ 5 km/h đến dưới 10 km/h.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe chạy dưới tốc độ tối thiểu trên những đoạn đường bộ có quy định tốc độ tối thiểu cho phép.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","");
        itemAdd(R.drawable.img,"Chạy quá tốc độ quy định từ 10 km/h đến 20 km/h.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","");
        itemAdd(R.drawable.img,"Không tuân thủ quy định về khoảng cách an toàn đối với xe chạy liền trước khi chạy trên đường cao tốc.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","");
        itemAdd(R.drawable.img,"Chạy quá tốc độ quy định trên 20 km/h.","Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng.","");
        itemAdd(R.drawable.img,"Không chú ý quan sát, điều khiển xe chạy quả tốc độ quy định gây tai nạn giao thông.","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng.","");
        itemAdd(R.drawable.img,"Điều khiển xe máy chuyên dùng có tốc độ thiết kế nhỏ hơn 70 km/h, máy kéo đi vào đường cao tốc.","Phạt tiền từ 10.000.000 đồng đến 12.000.000 đồng.","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng");
        itemAdd(R.drawable.img,"Không đảm bảo an toàn khi di chyển.","Phạt tiền từ 10.000.000 đồng đến 12.000.000 đồng.","");
    }

    private void horn() {
        itemAdd(R.drawable.img,"Bấm còi, rú ga liên tục","Phạt tiền từ 400.000 đồng đến 600.000 đồng","");
        itemAdd(R.drawable.img,"Bấm còi hơi, sử dụng đền chiếu a trong đô thị, khu đông dân cư","Phạt tiên gừ 400.000 đồng đên 600.000 đồng","");
    }

    private void cmd_guiding(){
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh hoặc chỉ dẫn của biển báo hiệu, vạch kẻ đường.","Phạt tiền từ 80.000 đồng đến 100.000 đồng","");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của biển báo hiệu, vạch kẻ đường.","Phạt tiền từ 100.000 đồng đến 200.000 đồng","");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh của đèn tín hiệu giao thông.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của người điều khiển giao thông hoặc người kiểm soát giao thông.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của biển báo hiệu, vạch kẻ đường khi đi qua đường ngang, cầu chung.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của nhân viên gác đường ngang, cầu chung khi đi qua đường ngang, cầu chung.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh hoặc chỉ dẫn của đèn tín hiệu, biển báo hiệu, vạch kẻ đường.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh của người điều khiển giao thông, người kiểm soát giao thông.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh hoặc chỉ dẫn của đèn tín hiệu, biển báo hiệu, vạch kẻ đường.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh của người điều khiển giao thông hoặc người kiểm soát giao thông.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của biển báo hiệu, vạch kẻ đường hoặc hướng dẫn của nhân viên gác đường ngang, cầu chung, hầm khi đi qua đường ngang, cầu chung, hầm.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, hướng dẫn của người điều khiển giao thông hoặc người kiểm soát giao thông","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh của đèn tín hiệu giao thông.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành việc thu hồi Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường phương tiện giao thông cơ giới đường bộ theo quy định.","Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với cá nhân, từ 4.000.000 đồng đến 8.000.000.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của biển báo hiệu, vạch kẻ đường khi đi qua đường ngang, cầu chung.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Vượt đường ngang, cầu chung khi đèn đỏ đã bật sáng.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng","cascas");
        itemAdd(R.drawable.img,"Không chấp hành hiệu lệnh, chỉ dẫn của nhân viên gác đường ngang, cầu chung khi đi qua đường ngang, cầu chung.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","cascas");
        itemAdd(R.drawable.img,"Không chấp hành việc kiểm tra tải trọng, khổ giới hạn xe khi có tín hiệu, hiệu lệnh yêu cầu kiểm tra tải trọng, khổ giới hạn xe.","Phạt tiền từ 14.000.000 đồng đến 16.000.000 đồng","cascas");
    }
    private void change_direct(){
        itemAdd(R.drawable.img_2,"Không đi bên phải theo chiều đi của mình, đi không đúng phần đường quy định.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Chuyển hướng không báo hiệu trước.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Vượt bên phải trong các trường hợp không được phép.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Quay đầu xe trong hầm đường bộ.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Không nhường đường cho xe xin vượt khi có đủ điều kiện an toàn hoặc gây cản trở đối với xe cơ giới xin vượt, gây cản trở xe ưu tiên.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Không nhường đường cho xe đi trên đường ưu tiên, đường chính từ bất kỳ hướng nào tới tại nơi đường giao nhau.","Phạt tiền từ 80.000 đồng đến 100.000 đồng","cascas");
        itemAdd(R.drawable.img_2,"Chuyển hướng không nhường quyền đi trước cho người đi bộ, xe lăn của người khuyết tật qua đường tại nơi có vạch kẻ đường dành cho người đi bộ.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Chuyển hướng không nhường quyền đi trước cho xe thô sơ đang đi trên phần đường dành cho xe thô sơ.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Chuyển hướng không nhường đường cho các xe đi ngược chiều.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Chuyển hướng không nhường đường cho người đi bộ, xe lăn của người khuyết tật đang qua đường tại nơi không có vạch kẻ đường cho người đi bộ.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Quay đầu xe ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, ngầm, gầm cầu vượt.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Lùi xe ở đường một chiều, đường có biển Cấm đi ngược chiều, khu vực cấm dừng, trên phần đường dành cho người đi bộ qua đường, nơi đường bộ giao nhau, nơi đường bộ giao nhau cùng mức với đường sắt, nơi tầm nhìn bị che khuất.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Lùi xe không quan sát hoặc không có tín hiệu báo trước.","oặc không có tín hiệu báo trước.","cascas");
        itemAdd(R.drawable.img_2,"Chuyển hướng đột ngột trước đầu xe cơ giới đang chạy.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Vượt rào chắn đường ngang, cầu chung khi chắn đang dịch chuyển."," Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Vượt đường ngang, cầu chung khi đèn đỏ đã bật sáng.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Không đi đúng phần đường quy định.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Không nhường đường cho xe đi trên đường ưu tiên, đường chính từ bất kỳ hướng nào tới tại nơi đường giao nhau.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Vượt qua dải phân cách.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Qua đường không đúng nơi quy định hoặc không bảo đảm an toàn.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Không nhường đường theo quy định, không báo hiệu bằng tay khi chuyển hướng","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_2,"Vượt rào chắn đường ngang, cầu chung khi chắn đang dịch chuyển hoặc đã đóng.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Vượt qua đường ngang khi đèn đỏ đã bật sáng.","Phạt tiền từ 60.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Tránh xe, vượt xe không đúng quy định.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Không nhường đường cho xe đi ngược chiều theo quy định tại nơi đường hẹp, đường dốc, nơi có chướng ngại vật.","Phạt tiền từ 400.000 đồng đến 600.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Điều khiển xe chạy ở làn dừng xe khẩn cấp hoặc phần lề đường của đường cao tốc.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Chuyển làn đường không đúng nơi cho phép hoặc không có tín hiệu báo trước khi chạy trên đường cao tốc.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Không nhường đường hoặc gây cản trở xe được quyền ưu tiên đang phát tín hiệu ưu tiên đi làm nhiệm vụ.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Quay đầu xe tại nơi đường bộ giao nhau cùng mức với đường sắt.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Quay đầu xe tại nơi đường hẹp, đường dốc, đoạn đường cong tầm nhìn bị che khuất, nơi có biển báo cấm quay đầu xe.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Lùi xe, quay đầu xe trong hầm đường bộ.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Quay đầu xe trên đường cao tốc.","Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Lùi xe trên đường cao tốc.","Phạt tiền từ 10.000.000 đồng đến 12.000.000 đồng","cascas");
    }
    private void stop_park(){
        itemAdd(R.drawable.img_3,"Dừng xe đột ngột.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên phần đường xe chạy ở đoạn đường ngoài đô thị nơi có lề đường.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trong hầm đường bộ không đúng nơi quy định.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Để xe ở lòng đường đô thị, hè phố trái quy định của pháp luật.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Đỗ xe ở lòng đường đô thị gây cản trở giao thông, đỗ xe trên đường xe điện, đỗ xe trên cầu gây cản trở giao thông.","Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Không tuân thủ quy định về dừng xe, đỗ xe tại nơi đường bộ giao nhau cùng mức với đường sắt.","   Phạt tiền từ 80.000 đồng đến 100.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Đỗ, để xe ở hè phố trái quy định của pháp luật.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên phần đường xe chạy ở đoạn đường ngoài đô thị nơi có lề đường rộng.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe không sát mép đường phía bên phải theo chiều đi ở nơi đường có lề đường hẹp hoặc không có lề đường.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe ngược với chiều lưu thông của làn đường.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên dải phân cách cố định giữa hai phần đường xe chạy.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe không đúng vị trí quy định những đoạn đường đã có bố trí nơi dừng xe, đỗ xe.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Đỗ xe trên dốc không chèn bánh.","Phạt tiền từ 200.000 đồng đến 400.000 đồng Xem chi tiết.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe nơi có biển Cấm dừng xe và đỗ xe.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Đỗ xe nơi có biển Cấm đỗ xe hoặc biển Cấm dừng xe và đỗ xe","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe tại bên trái đường một chiều hoặc bên trái (theo hướng lưu thông của đường đôi.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên đoạn đường cong hoặc gần đầu dốc nơi tầm nhìn bị che khuất.","Phạt tiền từ 200.000 đồng đến 400.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên cầu, gầm cầu vượt, song song với một xe khác đang dừng, đỗ.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe nơi đường bộ giao nhau hoặc trong phạm vi 5 m tính từ mép đường giao nhau.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe tại điểm dừng đón, trả khách của xe buýt.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trước cổng hoặc trong phạm vi 5 m hai bên cổng trụ sở cơ quan, tổ chức có bố trí đường cho xe ô tô ra vào.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe tại nơi phần đường có bề rộng chỉ đủ cho một làn xe.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe che khuất biển báo hiệu đường bộ.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe tại nơi mở dải phân cách giữa.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe ở lòng đường đô thị trái quy đinh.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên đường xe điện, đường dành riêng cho xe buýt, trên miệng cống thoát nước, miệng hầm của đường điện thoại, điện cao thế, các chỗ dành riêng cho xe chữa cháy lấy nước, trên phần đường dành cho người đi bộ qua đường","Phạt tiền từ 200.000 đồng đến 400.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Rời vị trí lái, tắt máy khi dừng xe.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Khi dừng xe, đỗ xe không có tín hiệu báo cho người điều khiển phương tiện khác biết.","Phạt tiền từ 200.000 đồng đến 400.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trong phạm vi an toàn đường ngang, cầu chung.","Phạt tiền từ 100.000 đồng đến 200.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Khi đỗ xe chiếm một phần đường xe chạy không đặt ngay báo hiệu nguy hiểm theo quy định.","Phạt tiền từ 200.000 đồng đến 400.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trong phạm vi an toàn của đường sắt.","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trong hầm đường bộ không đúng nơi quy định.","Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe trên đường cao tốc không đúng nơi quy định","Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng.","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đõo xe, quay đầu xe, lùi xe, tránh xe, vượt xe, chuyển hướng, chuyển làn đường không đúng quy định gây tai nạn giao thông.","Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng","cascas");
        itemAdd(R.drawable.img_3,"Dừng xe, đỗ xe, quay đầu xe trong phạm vi an toàn đường ngang, cầu chung","Phạt tiền từ 800.000 đồng đến 1.000.000 đồng.","cascas");
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        lawAdapter = new LawAdapter(this, law);
        recyclerView.setAdapter(lawAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        defineItem();
        lawAdapter.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_list_other_law);
    }
    private void itemAdd(int img, String tittle, String content, String detail){
        law.add(new Law(img,tittle,content,detail));
    }
}