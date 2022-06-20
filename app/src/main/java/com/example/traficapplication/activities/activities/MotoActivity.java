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

public class MotoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LawAdapter lawAdapter;
    private ArrayList<Law> law = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);
        initUi();
        setRecylerView();

    }



    private void defineAdapter() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b.get("lawPos").equals("0")) {
            itemAdd(R.drawable.img_1, "Không chấp hành hiệu lệnh chỉ dẫn , của biển báo hiệu , vạch kẻ đường", "phạt 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Không chấp hành tín hiệu đèn giao thông", "phạt 600.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Không chấp hành hiệu lệnh, chỉ dẫn của báo hiệu, vạch kẻ đường khi đi qua đường ngang cầu chung", "phạt 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Vượt đường ngang, cầu chung khi đèn đỏ bật sáng", "phạt 600.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Không chấp hành hiệu lệnh , chỉ dẫn của nhân viên gác đường ngang, cầu chung khi đi qua đường ngang cầu chung", "phạt 600.000 đồng đến 1.000.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("1")) {
            itemAdd(R.drawable.img_2, "Lùi xe moto ba bánh không quan sát hoặc không có tín hiệu báo trước", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Không tuân thủ quy định về nhường đường tại nơi giao nhau", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Chuyển đường không đúng nơi được phép hoặc không có tín hiệu báo trước", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Tránh xe không đúng quy định", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Quay đầu xe nơi không được quay xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Không nhường đường cho xe ngược chiều theo quy định tại đường hẹp,dốc, nơi có chướng ngại vật.", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Quay đầu xe nơi không được quay xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Chuyển hướng không nhường quyền đi trước cho người đi bộ, xe lăn của người khuyết tật qua đường tại nơi có vạch kẻ đường dành cho người đi bộ", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Chuyển hướng không nhường quyền đi trước cho xe thô sơ đang đi trên phần đường dành cho xe thô sơ", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("2")){
            itemAdd(R.drawable.img_1, "Dừng xe, đỗ xe trên phần đường xe chạy ở đoạn đường ngoài đô thị nơi có lề đường", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Dừng xe, đỗ xe ở lòng đường gây cản trở giao thông", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Dừng xe, đỗ xe ở lòng đường gây cản trở giao thông", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Đỗ xe ở lòng đường đô thị hè phố trái quy định pháp luật", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Dừng xe, đỗ xe trên đường xe điện điểm dừng đón trả khách của xe bus, nơi đường bộ giao nhau, trên phần đường dành cho người đi bộ qua đường", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Dừng xe ở nơi có biển “Cấm dừng và đổ xe”", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Dừng xe, đỗ xe trên phần đường xe chạy ở đoạn đường ngoài đô thị nơi có lề đường", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Không tuân thủ các quy định về dừng , đổ xe tại nơi đường bộ giao nhau cùng mức với đường sắt", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Dừng xe ở nơi có biển “Cấm dừng và đổ xe”", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Không tuân thủ các quy định về dừng , đổ xe tại nơi đường bộ giao nhau cùng mức với đường sắt", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Dừng xe đổ xe trên cầu", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("3")){
            itemAdd(R.drawable.img_1, "Bấm Còi từ 22 giờ ngày hôm trước đến 5 giờ ngày hôm sau khu dân cư", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Xe được quyền ưu tiên lắp đặt sử dụng các thiết bị phát tín hiệu ưu tiên không đúng quy định hoặc sử dụng thiết bị phát tín hiệu ưu tiên mà không có giấy phép của cơ quan thầm quyền cấp hoặc có giấy phép cơ quan nhưng không còn hạn sử dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Xe không được quyền ưu tiên lắp đặt sử dụng thiết bị tín hiệu của xe được quyền ưu tiên", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Đỗ xe ở lòng đường đô thị hè phố trái quy định pháp luật", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Bấm còi, rú ga trong khu đô thị dân cư", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Điều khiển xe không còi hoặc còi không có tác dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Sử dụng còi không đúng chuẩn kỹ thuật xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
        }
        if (b.get("lawPos").equals("4")){
            itemAdd(R.drawable.img_1, "Bấm Còi từ 22 giờ ngày hôm trước đến 5 giờ ngày hôm sau khu dân cư", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Xe được quyền ưu tiên lắp đặt sử dụng các thiết bị phát tín hiệu ưu tiên không đúng quy định hoặc sử dụng thiết bị phát tín hiệu ưu tiên mà không có giấy phép của cơ quan thầm quyền cấp hoặc có giấy phép cơ quan nhưng không còn hạn sử dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Xe không được quyền ưu tiên lắp đặt sử dụng thiết bị tín hiệu của xe được quyền ưu tiên", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Đỗ xe ở lòng đường đô thị hè phố trái quy định pháp luật", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Bấm còi, rú ga trong khu đô thị dân cư", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Điều khiển xe không còi hoặc còi không có tác dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Sử dụng còi không đúng chuẩn kỹ thuật xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("5")){
            itemAdd(R.drawable.img_1, "Chở người ngồi trên xe sử dụng ô (dù)", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, " Không đội mũ bảo hiểm cho người đi ô tô xe máy không cài quai đúng quy cách khi điều khiển tham gia giao thông trên đường bộ", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Chở người ngồi trên xe không đội mũ bảo hiểm cho người đi ô tô xe máy hoặc đội mũ cho người đi mô tô xe máy không đúng quy cách", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Chở theo 2 người trên xe", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Chở theo 3 người trên xe", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Xếp hàng hóa vượt quá mức quy định", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Chở hàng vượt trọng tải thiết kế được ghi giấy đăng ký xe đối với xe có quy định về trọng tải thiết kế", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Sử dụng ô (dù)", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("6")){
            itemAdd(R.drawable.img_1, "Không sử dụng đèn chiếu sáng trong thời gian từ 19 giờ ngày hôm trước đến 5 giờ ngày hôm sau hoặc khi sương mù thời tiết hạn chế tầm nhìn", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Sử dụng đèn chiếu xa khi tránh xe đi ngược chiều", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Chạy xe đường hầm đường bộ sử dùng đèn chiếu sáng gần", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Điều khiển xe không có biển số hoặc có nhưng không có tác dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Điều khiển xe không có đèn báo hoặc có nhưng không tác dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Điều khiển xe không có gương chiếu hậu bên trái nhưng người điều khiển hoặc có nhưng không có tác dụng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe gắn biển số không đúng quy định", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Điều khiển xe gắn biển số không rõ chữ số", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Điều khiển xe gắn biến số bị bẻ cong bị che lấp bị hỏng", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Điều khiển xe gắn biển số sơn dán hoặc thêm thay đổi chữ số hoặc màu sắc của chữ nền biển số", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe không có đền chiếu gần xa hoặc có nhưng không có tác dụng không đúng tiêu chuẩn thiết kế", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Điều khiển xe lắp chiếu sáng về phía sau xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Điều khiển xe không gắn biển số đối với xe quy định phải gắn biển số", "Phạt tiền từ 300.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Điều khiển xe gắn biển số không đúng với Giấy đăng ký xe hoặc gắn biển số không do cơ quan có thẩm quyền cấp", "Phạt tiền từ 300.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Bán biển số xe mô tô xe gắn máy kể cả xe điện và các loại xe tương tự xe gắn máy mà không phải là biển số do cơ quan nhà nước có thẩm quyền sản xuất hoặc không được cơ quan nhà nước có thẩm quyền cho phép ", "Phạt tiền từ 1.000.000 đồng đến 4.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Đưa phương tiện không gắn biển số tham gia giao thông", "Phạt tiền từ 800.000 đồng đến 2.000.000 đồng đối với cá nhân từ 1.6000.000 đồng đến 4.000.000 đồng đối với tổ chức", "cascas");
            itemAdd(R.drawable.img_1, "Đưa phương tiện gắn biển số không đúng với giấy đăng ký xe hoặc gắn biển số không do có quan có thầm quyền cấp tham gia giao thông", "Phạt tiền từ 800.000 đồng đến 2.000.000 đồng đối với cá nhân từ 1.6000.000 đồng đến 4.000.000 đồng đối với tổ chức", "cascas");
            itemAdd(R.drawable.img_1, "Điều khiển phương tiện không gắn biển số hoặc tạm thời hoặc biển số tạm thời không do cơ quan có thẩm quyền cấp(nếu có quy định phải gắn biển số tạm thời)", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng", "cascas");


        }
        if (b.get("lawPos").equals("7")){
            itemAdd(R.drawable.img_1, "Đi vào khu vực cấm đường có biển báo hiệu có nội dung cấm đi vào đối với loại phương tiện đang điều khiển", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Đi ngược chiều của đường 1 chiều , đi ngược chiều trên đường có bảng đường 1 chiều", "Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("8")){
            itemAdd(R.drawable.img_1, "Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt 50mlgam đến 80mlgam trên 100ml máu ", "Phạt tiền từ 4.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe trên đường mà hơi thở có nồng độ cồn vượt 80ml/100ml máu hoặc 0.4ml/1l khí thở", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Không chấp hành yêu cầu kiểm tra về nồng độ cồn của người thi hành công vụ", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Điều khiển xe trên đường mà trong cơ thể có ma túy", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Không chấp hành yêu cầu kiểm tra về chất ma túy của người thi hành công vụ", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("9")){
            itemAdd(R.drawable.img_1, "Điều khiển xe không có giấy đăng ký theo quy định hoặc giấy hết hạn ", "Phạt tiền từ 300.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Sử dụng giấy xe đã bị tẩy xóa", "Phạt tiền từ 300.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Sử dụng xe giấy không giống số khung, số máy của xe hoặc không do cơ quan thẩm quyền cung cấp", "Phạt tiền từ 300.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Không có hoặc không mang theo giấy đăng ký xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Không có hoặc không mang giấy phép lái xe", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Không có giấy phép  lái xe  hoặc sử dụng giấy phép không do cơ quan thẩm quyền cấp, giấy phép bị tẩy xóa", "Phạt tiền từ 800.000 đồng đến 1.200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Có giấy phép lái xe quốc tế do các nước tham gia Công ước về giao thông đường bộ năm 1968 cấp (trừ giấy phép lái xe quốc tế do việt nam cấp) nhưng không mang theo giấy phép lái xe quốc tế", "Phạt tiền từ 800.000 đồng đến 1.200.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Có giấy phép lái xe nhưng không phù hợp với xe đang điều khiển ", "Phạt tiền từ 3.000.000 đồng đến 4.000.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("10")){
            itemAdd(R.drawable.img_1, "Điều khiển xe chạy dàn hàng ngang từ 3 xe trở lên", "Phạt tiền từ 100.000 đồng đến 200.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Ngồi phía sau  vòng qua tay người ngồi trước để điều khiển xe", "Phạt tiền từ 200.000 đồng đến 300.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Điều khiển xe thành đoàn gây cản trở giao thông", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Điều khiển xe có liên quan trực tiếp đến vụ tai nạn giao thông mà không dừng lại,không giữ nguyên hiện trường,không tham gia cấp cứu người bị nạn", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Người đang điều khiển xe hoặc chở người ngồi trên xe bám kéo đẩy xe khác vật khác, dẫn dắt súc vật, mang vác cồng kềnh", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Điều khiển xe kéo theo xe khác,vật khác", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Người đang điều khiển xe sử dụng ô , điện thoại, tai nghe trừ thiết bị trợ thính", "Phạt tiền từ 600.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Sử dụng chân chóng hoặc vật khác quệt xuống đường khi xe đang chạy", "Phạt tiền từ 2.000.000 đồng đến 3.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Điều khiển xe đi vào đường cao tốc", "Phạt tiền từ 2.000.000 đồng đến 3.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Buông 2 tay khi điều khiển xe", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Dùng chân điều khiển xe", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Nằm trên yên điều khiển xe", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");

        }

    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        lawAdapter = new LawAdapter(this, law);
        recyclerView.setAdapter(lawAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        defineAdapter();
        lawAdapter.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_list_moto_law);
    }
    private void itemAdd(int img, String tittle, String content, String detail){
        law.add(new Law(img,tittle,content,detail));
    }
}