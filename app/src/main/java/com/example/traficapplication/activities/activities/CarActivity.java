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

public class CarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LawAdapter lawAdapter;
    private ArrayList<Law> law = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        initUi();
        setRecylerView();
    }



    private void defineAdapter() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b.get("lawPos").equals("0")) {
            itemAdd(R.drawable.img_1, "Không chấp hành hiệu lệnh chỉ dẫn , của biển báo hiệu , vạch kẻ đường", "phạt 200.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Không chấp hành tín hiệu đèn giao thông", "phạt 3.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Không chấp hành hiệu lệnh, hướng dẫn của người điều khiển giao thông hoặc người kiểm soát giao thông", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Điều khiển xe lạng lách, đánh võng không chấp hành hiệu lệnh dừng xe của người thi hành công vụ hoặc gây tai nạn giao thông ", "Phạt tiền từ 18.000.000 đồng đến 20.000.000 đồng.", "cascas");
            itemAdd(R.drawable.img_5, "Điều khiển xe ô tô có tay lái bên phải, xe ô tô của người nước ngoài vào Việt Nam du lịch tham gia giao thông mà không có xe dẫn đường theo quy định", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Không chấp hành hiệu lệnh, chỉ dẫn của biển báo hiệu, vạch kẻ đường khi đi qua đường ngang, cầu chung", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Vượt đường ngang, cầu chung khi đèn đỏ đã bật sáng", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng.", "cascas");

        }
            if (b.get("lawPos").equals("1")) {
                itemAdd(R.drawable.img_2, "Chuyển làn đường không đúng nơi cho phép hoặc không có tín hiệu báo trước", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
                itemAdd(R.drawable.img_5, "Không tuân thủ các quy định về nhường đường tại nơi đường bộ giao nhau", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
                itemAdd(R.drawable.img_6, "Quay đầu xe trái quy định trong khu dân cư", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
                itemAdd(R.drawable.img_1, "Quay đầu xe ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu câu, ngâm, gầm cầu vượt", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
                itemAdd(R.drawable.img_3, "Chuyển hướng không giảm tốc độ hoặc không có tín hiệu báo hướng rẽ", " Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
                itemAdd(R.drawable.img_3, "Chuyển hướng không giảm tốc độ hoặc không có tín hiệu báo hướng rẽ", " Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
                itemAdd(R.drawable.img_3, "Chuyển hướng không giảm tốc độ hoặc không có tín hiệu báo hướng rẽ", " Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");

            }
        if (b.get("lawPos").equals("2")){
            itemAdd(R.drawable.img_2, "Khi dừng xe, đỗ xe không có tín hiệu báo cho người điều khiển phương tiện khác biệt", " Phạt tiền từ 200.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Khi đỗ xe chiếm một phần đường xe chạy không đặt ngay báo hiệu nguy hiểm theo quy định. ", "Phạt tiền từ 200.000 đồng đến 400.000 đồng ", "cascas");
            itemAdd(R.drawable.img_6, "Dừng xe, đỗ xe trên phần đường xe chạy ở đoạn đường ngoài đô thị nơi có lề đường rộng", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Dừng xe, đỗ xe không sát mép đường phía bên phải theo chiều đi ở nơi đường có lề đường hẹp hoặc không có lề đường", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Dừng xe, đỗ xe ngược với chiều lưu thông của làn đường ", " Phạt tiền từ 400.000 đồng đến 600.000 đồng ", "cascas");
            itemAdd(R.drawable.img_2, "Khi dừng xe, đỗ xe không có tín hiệu báo cho người điều khiển phương tiện khác biết", "Phạt tiền từ 200.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Khi đỗ xe chiếm một phần đường xe chạy không đặt ngay báo hiệu nguy hiểm theo quy định.", " Phạt tiền từ 200.000 đồng đến 400.000 đồng ", "cascas");
            itemAdd(R.drawable.img_3, "Dừng xe, đỗ xe trên phần đường xe chạy ở đoạn đường ngoài đô thị nơi có lề đường rộng ", " Phạt tiền từ 200.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Phạt tiền từ 400.000 đồng đến 600.000 đồng Xem chi tiết Dừng xe, đỗ xe không sát mép đường phía bên phải theo chiều đi ở nơi đường có lề đường hẹp hoặc không có lề đường", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Dừng xe, đỗ xe ngược với chiều lưu thông của làn đường", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Dừng xe, đỗ xe trên dải phân cách cố định ở giữa hai phần đường xe chạy", " Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("3")){
            itemAdd(R.drawable.img_1, "Không gắn biển báo hiệu ở phía trước xe kéo, phía sau xe được kéo", "Phạt tiền từ 200.000 đồng đến 400.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Bấm còi trong đô thị và khu đông dân cự trong thời gian từ 22 giờ ngày hôm trước đến 5 giờ ngày hôm sau", "Phạt tiền từ 200.000 đồng đến 400.000 đồng ", "cascas");
            itemAdd(R.drawable.img_3, "Xe được quyền ưu tiên lắp đặt, sử dụng thiết bị phát tín hiệu ưu tiên không đúng quy định hoặc sử dụng thiết bị phát tín hiệu ưu tiên mà không có giấy CẢNH BÁO phép của cơ quan có thẩm quyền cấp hoặc có giấy phép của cơ quan có CẢNH BÁO thẩm quyền cấp nhưng không còn giá trị sử dụng", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Bấm còi, rú ga liên tục", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng ", "cascas");
            itemAdd(R.drawable.img_5, "Bấm còi hơi, sử dụng đèn chiếu xa trong đô thị, khu đông dân cư ", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Không có báo hiệu để người lái xe khác biết khi buộc phải dừng xe, đỗ xe trên đường cao tốc không đúng nơi quy đinh", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng ", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe lắp đặt, sử dụng còi vượt quá âm lượng theo quy định", "Phạt tiền từ 2.000.000 đồng đến 3.000.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("4")){
            itemAdd(R.drawable.img_1, "Điều khiển xe chạy tốc độ thấp hơn các xe khác đi cùng chiều mà không đi về bên phải phần đường xe chạy ", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe chạy quá tốc độ quy định từ 5 km/h đến dưới 10 km/h ", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Không giữ khoảng cách an toàn để xảy ra va chạm với xe chạy trước hoặc không giữ khoảng cách theo quy định của biển báo hiệu “Cự ly tối thiểu giữa hai xe", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng ", "cascas");
            itemAdd(R.drawable.img_4, "Không giảm tốc độ và nhường đường khi điều khiển xe chạy từ trong ngõ, đường nhánh ra đường chính", " Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Điều khiển xe chạy dưới tốc độ tối thiểu trên những đoạn đường bộ có quy định tốc độ tối thiểu cho phép", " Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_6, "Điều khiển xe chạy ở làn dừng xe khẩn cấp hoặc phần lề đường của đường cao tốc", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Không tuân thủ quy định về khoảng cách an toàn đối với xe chạy liền trước khi chạy trên đường cao tốc", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_3, "Điều khiển xe chạy quá tốc độ quy định từ 10 km/h đến 20 km/h ", " Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Điều khiển xe chạy quá tốc độ quy định trên 20 km/h đến 35 km/h", "Phạt tiền từ 6.000.000 đồng đến 8.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Không chú ý quan sát, điều khiển xe chạy quá tốc độ quy định gây tai nạn giao thông", "Phạt tiền từ 10.000.000 đồng đến 12.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Không chú ý quan sát, điều khiển xe chạy quá tốc độ quy định gây tai nạn giao thông ", "Phạt tiền từ 10.000.000 đồng đến 12.000.000 đồng", "cascas");


        }
        if (b.get("lawPos").equals("5")){
            itemAdd(R.drawable.img_1, "Chở người trên buồng lái quá số lượng quy định", "Phạt tiền từ 400.000 đồng đến. 600.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe ô tô chở hành khách, ô tô chở người chở quá từ 2 người trở lên trên xe đến 9 chỗ, chở quá từ 3 người trở lên trên xe 10 chỗ đến xe 16 chỗ, chở quá từ 4 người trở lên trên xe 16 chỗ đến xe 30 chỗ, chở quá từ 5 người trở lên trên xe trên 30 chỗ ", "Phạt tiền từ 400.000 đồng đến 600.000 đồng trên mỗi người vượt quá đối với chủ xe là cá nhân. - Phạt tiền từ 800.000 đồng đến 1.200.000 đồng trên mỗi người vượt quá đối với chủ xe là tổ chức", "cascas");
            itemAdd(R.drawable.img_3, "Điều khiển xe ô tô chở hành khách chạy tuyến có cự ly lớn hơn 300 km chở quá từ 2 người trở lên trên xe đến 9 chỗ, chở quá từ 3 người trở lên trên xe 16 chỗ đến xe 16 chỗ, chở quá từ 4 người trở lên trên xe 16 chỗ đến xe 30 chỗ, chở quá từ 5 người trở lên trên xe trên 30 chỗ ", "Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng trên mỗi người vượt quá đối với chủ xe là cá nhân. Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng trên mỗi người vượt quá đối với chủ xe là tổ chức. ", "cascas");
            itemAdd(R.drawable.img_4, "Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển hoặc trực tiếp điều khiển xe ô tô và các loại xe tương tự xe ô tô (kể cả rơ moóc và sơ mi rõ moóc) chở hàng vượt trọng tải (khối lượng hàng chuyên chở) cho phép tham gia giao thông được ghi trong Giấy chứng nhận kiểm định an. toàn kỹ thuật và bảo vệ môi trường của xe trên 10% đến 30%, trên 20% đến 30% đối với xe xi téc chở chất lỏng", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức", "cascas");
            itemAdd(R.drawable.img_5, "Giao phương tiện hoặc để cho người làm công, người đại diện điều khiển hoặc trực tiếp điều khiển xe kéo theo rơ moóc, sơ mi rơ moóc mà khối lượng toàn bộ (bao gồm khối lượng bản thân rơ moóc, sơ mi rơ moóc và khối lượng hàng chuyên chở) của rơ moóc, sơ mi rơ moóc vượt khối lượng cho phép kéo theo được ghi trong giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường của xe trên 10% đến 30%", " Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức", "cascas");

        }
        if (b.get("lawPos").equals("6")){
            itemAdd(R.drawable.img_6, "Tự ý cắt, hàn, đục lại số khung, số máy xe ô tô và các loại xe tương tự xe ô tô ", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức. ", "cascas");
            itemAdd(R.drawable.img_2, "Đưa xe ô tô và các loại xe tương tự xe ô tô đã bị cắt, hàn, đục lại số khung, số máy trái quy định tham gia giao thông", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức", "cascas");
            itemAdd(R.drawable.img_3, "Không thực hiện đúng quy định về biển số, quy định về kẻ chữ trên thành xe và cửa xe ô tô và các loại xe tương tự xe ô tô", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức. ", "cascas");
            itemAdd(R.drawable.img_2, "Bán biển số xe ô tô và các loại xe tương tự xe ô tô không phải là biển số do cơ quan nhà nước có thẩm quyền sản xuất hoặc không được cơ quan nhà nước cấp phép", "Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng đối với cá nhân, từ 2.000.000 đồng đến 4.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Sản xuất biển số trái phép hoặc sản xuất, lắp ráp trái phép xe ô tô và các loại xe tương tự xe ô tô", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng đối với cá nhân, từ 6.000.000 đồng đến 10.000.000 đồng đối với tổ chức Xem chi tiết Lắp kính chắn gió, kính cửa của xe ô tô và các loại xe tương tự", "cascas");
            itemAdd(R.drawable.img_2, "xe ô tô không phải là loại kính an toàn.", "Phạt tiền từ 300.000 đồng đến 400.000 đồng đối với cá nhân, từ 600.000 đồng đến 800.000 đồng đối với tổ chức", "cascas");
            itemAdd(R.drawable.img_3, "Tự ý thay đổi màu sơn của xe không đúng với màu sơn ghi trong Giấy đăng ký xe ô tô và các loại xe tương tự xe ô tô", "Phạt tiền từ 300.000 đồng đến 400.000 đồng đối với cá nhân, từ 600.000 đồng đến 800.000 đồng đối với tổ chức ", "cascas");

        }
        if (b.get("lawPos").equals("7")){
            itemAdd(R.drawable.img_1, "Đi vào khu vực cấm, đường có biển báo hiệu có nội dung cấm đi vào đối với loại phương tiện đang điều khiển", "Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Đi ngược chiều của đường một chiều, đi ngược chiều trên đường có biến “Cấm đi ngược chiều", "Phạt tiền từ 3.000.000 đồng đến 5.000.000 đồng ", "cascas");

        }if (b.get("lawPos").equals("8")){
            itemAdd(R.drawable.img_1, "Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 50 miligam đến 80 miligam/100 mililít máu hoặc vượt quá 0,25 miligam đến 0,4 miligam/1 lít khí thở.", "Phạt tiền từ 16.000.000 đồng đến 18.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_2, "Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 80 miligam/100 mililít máu hoặc vượt quá 0,4 miligam/1 lít khí thở", "Phạt tiền từ 30.000.000 đồng đến 40.000.000 đồng.", "cascas");
            itemAdd(R.drawable.img_3, "Không chấp hành yêu cầu kiểm tra về nồng độ cồn của người thi hành công vụ", "Phạt tiền từ 30.000.000 đồng đến 40.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_1, "Điều khiển xe trên đường mà trong cơ thể có chất ma túy", "Phạt tiền từ 30.000.000 đồng đến 40.000.000 đồng. ", "cascas");
            itemAdd(R.drawable.img_1, "Không chấp hành yêu cầu kiểm tra về chất ma túy của người thi hành công vụ ", " Phạt tiền từ 30.000.000 đồng đến 40.000.000 đồng.", "cascas");

        }
        if (b.get("lawPos").equals("9")){
            itemAdd(R.drawable.img_1, "Không làm thủ tục đổi lại Giấy đăng ký xe theo quy định khi xe đã được cải tạo hoặc khi thay đổi địa chỉ của chủ xe ", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức.", "cascas");
            itemAdd(R.drawable.img_2, "Khai báo không đúng sự thật hoặc sử dụng các giấy tờ, tài liệu giả để được cấp lại biển số, Giấy đăng ký xe, Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường xe ô tô và các loại xe tương tự xe ô tô", " Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức", "cascas");
            itemAdd(R.drawable.img_3, " Không làm thủ tục đăng ký sang tên xe (để chuyển tên chủ xe trong Giấy đăng ký xe sang tên của mình) theo quy định khi mua, được cho, được tặng, được phân bố, được điều chuyển, được thừa kế tài sản là xe ô tô và các loại xe tương tư xe ô tô", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức.", "cascas");
            itemAdd(R.drawable.img_4, "Không làm thủ tục khai báo với cơ quan đăng ký xe theo quy định trước khi cải tạo xe ô tô và các loại xe tương tự xe ô tô", "Phạt tiền từ 300.000 đồng đến 400.000 đồng đối với cá nhân, từ 600.000 đồng đến 800.000 đồng đối với tổ chức ", "cascas");
            itemAdd(R.drawable.img_5, "Tẩy xóa hoặc sửa chữa hồ sơ đăng ký xe ô tô và các loại xe tương tự xe ô tô", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức.", "cascas");
            itemAdd(R.drawable.img_6, "Không chấp hành việc thu hồi Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường xe ô tô và các loại xe tương tự xe ô tô ", "Phạt tiền từ 2.000.000 đồng đến 4.000.000 đồng đối với chủ xe là cá nhân. Phạt tiền từ 4.000.000 đồng đến 8.000.000 đồng đối với chủ xe là tổ chức", "cascas");
            itemAdd(R.drawable.img_2, "Có giấy phép lái xe nhưng không phù hợp với xe đang điều khiển ", "Phạt tiền từ 3.000.000 đồng đến 4.000.000 đồng", "cascas");

        }
        if (b.get("lawPos").equals("10")){
            itemAdd(R.drawable.img_1, "Không thắt dây an toàn khi điều khiển xe chạy trên đường ", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng ", "cascas");
            itemAdd(R.drawable.img_2, "Đưa xe ô tô và các loại xe tương tự xe ô tô có Giấy đăng ký xe nhưng không đúng với số khung số máy của xe (kế cả rơ moóc và sơ mi rơ moóc) tham gia giao thông Phạt tiền từ 4.000.000 đồng đến 6.000.000 đồng đối với chủ xe là cá nhân", "Phạt tiền từ 8.000.000 đồng đến 12.000.000 đồng đối với chủ xe là tổ chức.", "cascas");
            itemAdd(R.drawable.img_3, "Chở người trên xe ô tô không thắt dây an toàn (tại vị trí có trang bị dây an toàn) khi xe đang chạy", "Phạt tiền từ 800.000 đồng đến 1.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_4, "Dùng tay sử dụng điện thoại di động khi đang điều khiển xe chạy trên đường", "Phạt tiền từ 1.000.000 đồng đến 2.000.000 đồng", "cascas");
            itemAdd(R.drawable.img_5, "Không thực hiện biện pháp bảo đảm an toàn theo quy định khi xe ô tô bị hư. hỏng ngay tại nơi đường bộ giao nhau cùng mức với đường sắt ", "Phạt tiền từ 1.000.000 đồng ", "cascas");
            itemAdd(R.drawable.img_6, "Điều khiển xe có liên quan trực tiếp đến vụ tai nạn giao thông mà không dừng lại, không giữ nguyên hiện trường, không tham gia cấp cứu người bi nan", "Phạt tiền từ 400.000 đồng đến 600.000 đồng", "cascas");
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
        recyclerView = findViewById(R.id.rv_list_car_law);
    }
    private void itemAdd(int img, String tittle, String content, String detail){
        law.add(new Law(img,tittle,content,detail));
    }


}