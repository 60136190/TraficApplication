package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.TestAdapter;
import com.example.traficapplication.activities.adapters.TrickAdapter;
import com.example.traficapplication.activities.models.Test;
import com.example.traficapplication.activities.models.Trick;

import java.util.ArrayList;

public class TrickActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TrickAdapter trickAdapter;
    private ArrayList<Trick> tricks = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);
        initUi();
        setRecylerView();

    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        trickAdapter = new TrickAdapter(this, tricks);
        recyclerView.setAdapter(trickAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        itemAdd("Cấp phép","●Đường cấm dừng, cấm đỗ, cấm đi do UBND cấp tỉnh cấp.\n●Xe quá khổ, quá tải do: cơ quan quản lý đường bộ có thẩm quyền cấp phép");
        itemAdd("Nồng độ cồn","Người điều khiển xe mô tô, ô tô, xe máy kéo trên đường mà trong máu hoặc hơi thở có nồng độ cồn: Bị nghiêm cấm.");
        itemAdd("Khoảng cách an toàn tối thiểu","●35m nếu vận tốc lưu hành (V) = 60 (km/h)\n●55m nếu 60<V≤80\n●70m nếu 80<V≤100\n●100m nếu 100<V≤120\n●Dưới 60km/h: Chủ động và đảm bảo khoảng cách");
        itemAdd("Hỏi về tuổi (T)","●Gắn máy: 16T (dưới 50 cm³\n●Mô tô + B1 + B2: 18T");
        itemAdd("Trên đường cao tốc, trong đường hầm, đường vòng, đầu dốc, nơi tầm nhìn hạn chế","●Không được quay đầu xe, không được lùi, không vượt\n●Không được vượt trên cầu hẹp có một làn xe\n●Không được phép quay đầ xe ở phần đường dành cho người đi bộ qua đường.\n●Cấm lùi xe ở khu vực cấm dừng và nơi đường bộ giao nhau.");
        itemAdd("Tại nơi giao nhau không có tín hiệu đèn","●Có vòng xuyến: Nhường đường bên trái.\n●Không có vòng xuyến: Nhường đường bên phải.");
        itemAdd("Biển báo cấm", "Cấm ô tô (Gồm: mô tô ba bánh, xe lam, xe khách)\n⇒ Cấm xe tải ⇒ Cấm máy kéo\n⇒ Cấm rơ moóc, sơ mi rơ moóc.");
        itemAdd("Nhất chớm, nhì ưu, tam đường tứ hướng","●NHất chớm: Xe nào tới vạch trước thì được đi trước.\n●Nhì ưu: Xe ưu tiên được đi trước.\nThứ tự xe ưu tiên: Hỏa - Sự - An - Thương\n(Cứu hỏa - Quân sự - Công an - Cứu thương - Hộ dê - Đoàn xe tang)." +
                "\n●Tam đường: Xe ở đườn chính, đường ưu tiên.\n●Tứ hướng: Thứ tự hướng: Bên phải trống - Rẽ phải - Đi thẳng - Rẽ trái");
        itemAdd("Thứ tự ưu tiên với các xe ưu tiên: Hỏa - Sự - An - Thương","●Hỏa: Xe Cứu hỏa\n●Sự: Xe Quân sự\n●An: Xe Công an\n●Thương: Xe Cứu thương\n●Xe hộ đê, xe đi làm nhiệm vụ khẩn cấp\n●Đoàn xe tang");
        itemAdd("Các hạng giấy phép lái xe","●A1: Mô tô dưới 175 cm³ và xe ba bánh của người khuyết tật.\n●A2: Mô tô từ 175 cm³ trở lên.");
        itemAdd("Phân nhóm biển báo hiệu bao gồm:","●Biển nguy hiểm (Hình tam giác vàng).\n●Biển cấm (Vòng tròn đỏ)\n●Biển hiệu lênh (Vòng tròn xanh).\n●Biển chỉ dẫn (Hình vuông hoặc chữ nhật xanh).\n●Biển phụ (Hình vuông hoặc chữ nhật trắng đen): Hiệu lực nằm ở biển phụ khi có đặt biển phụ.");
        itemAdd("Tốc độ tối đa TRONG khu vực đông dân cư","●60km/h: Đối với đường đôi hoặc đường một chiều có từ hai làn xe cơ giới trở lên.\n●50km/h: Đối với đường hai chiều hoặc đường một chiều có một làn xe cơ giới.");
        itemAdd("Tốc độ tối đa NGOÀI khu vực đông dân cư (trừ đường cao tốc)","Tốc độ tối đa cho phép đối với\n●Xe máy chuyên dụng, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự trên đường bộ (trừ đường cao tốc): 40km/h \n●Tốc độ tối đa cho phép của các loại xe cơ giới, xe máy chuyên dùng trên đường cao tốc phải tuân thủ tốc độ tối đa, tốc độ tối thiểu và không vượt quá: 120km/h");
        itemAdd("Tăng số, giảm số","Tăng 1 Giảm 2 (giảm số chọn ý có từ “vù ga″).");
        itemAdd("Phương tiện giao thông đường bộ","Bao gồm phương tiện giao thông cơ giới đường bộ và phương tiện giao thông thô sơ đường bộ");
        itemAdd("Phương tiện tham gia giao thông đường bộ","Gồm phương tiện giao thông đường bộ và xe máy chuyên dùng.");
        itemAdd("Xe máy chuyên dùng","Gồm xe máy thi công, xe máy nông nghiệp, lâm nghiệp và các loại xe đặc chủng khác sử dụng vào mục đích quốc phòng, an ninh có tham gia giao thông đường bộ.");
        itemAdd("Hiệu lệnh người điều khiển giao thông","●Giơ tay thẳng đứng: Tất cả dừng, trừ xe đã ở trong ngã tư được phép đi." +
                "\n●Giang ngang tay: Trái phải đi; Trước sau dừng." +
                "\n●Tay phải giơ trước: Sau, phải dừng, trước rẽ phải, trái đi các hướng, người đi bộ qua đường đi sau người điều khiển.");
        itemAdd("Khái niệm và quy tắc","Tất cả các câu có đáp án bị nghiêm cấm, không cho phép hoặc không được phép thì chọn đáp án đó." +
                "\n●Tốc độ chậm đi về bên phải." +
                "\n●Chỉ sử dụng còi từ 5 giờ sáng đến 22 giờ tối." +
                "\n●Trong đô thị sử dụng đèn chiếu gần.\n●Không được phép lắp đặt còi đèn không đúng thiết kế, trừ phi được chấp thuận của cơ quan có thẩm quyền." +
                "\n●Xe mô tô không được kéo xe khác.\n●05 năm không cấp lại nếu sử dụng bằng lái đã khai báo mát." +
                "\n●Chuyển làn đường phải có tín hiệu báo trước.\n●Xe thô sơ phải đi làn đường nên phải trong cùng." +
                "\n●Tránh xe ngược chiều thì nhường đường qua đường hẹp và nhường xe lên dốc.\n●Đứng cách ray đường sắt 5m.\n●Vào cao tốc phải nhường đường cho xe đang chạy trên đường." +
                "\n●Xe thiết kế nhỏ hơn 70km/h không được vào cao tốc.\n●Trên cao tốc chỉ được dừng xe, đỗ xe ở nơi quy định.\n●Trong hầm chỉ được dừng xe, đỗ xe ở nơi quy định. " +
                "\n●Xe quá tải trọng phải do cơ quan quản lý đường bộ cấp phép.\n●Trọng lượng xe kéo rơ moóc phải lớn hơn rơ moóc.\n●Kéo xe không hệ thống hãm phải dùng thanh nối cứng."+
                "\n●Xe gắn máy tối đa 40km/h.\n●Xe cơ giới không bao gồm xe gắn máy.\n●Đường có giải phân cách được xem là đường đôi.\n●Giảm tốc độ, chú ý quan sát khi gặp biển báo nguy hiểm." +
                "\n●Giảm tốc độ, đi sát về bên phải khi xe sau xin vượt.\n●Điểm giao cắt đường sắt thì ưu tiên đường sắt." +
                "\n●Nhường đường cho xe ưu tiên có tín hiệu còi, cờ, đèn.\n●Không vượt xe khác trên đường vòng, khuất tầm nhìn.\n●Nơi có vạch kẻ đường dành cho người đi bộ thì nhường đường." +
                "\n●Dừng xe, đỗ xe cách lề đường, hè phố không quá 0,25 mét.\n●Dừng xe, đỗ xe trên đường hẹp cách xe khác 20 mét.\n●Giảm tốc độ trên đường ướt, đường hẹp và đèo dốc. " +
                "\n●Xe buýt đang dừng đón trả khách thì giảm tốc độ và từ từ vượt qua xe buýt.");
        itemAdd("Nghiệp vụ vận tải","●Không lái xe liên tục quá 4 giờ.\n●Khung làm việc 1 ngày của lái xe không quá 10 giờ.\n●Người kinh doanh vận tải không được tự ý thay đổi vị trí đón, trả khách.\n●Vận chuyển hàng nguy hiểm phải có giấy phép.");
        itemAdd("Kỹ thuật lái xe","●Xe mô tô xuống dốc dài cần sử dụng cả phanh trước và phanh sau để giảm tốc độ.\n●Thực hiện quay đầu xe với tốc độ thấp.");
        itemAdd("Các quy tắc sa hình khác","●Thứ tự ưu tiên không vòng xuyến: Xe vào ngã ba, ngã tư trước - Xe ưu tiên - Đường ưu tiên - Đường cùng cấp theo thứ tự bên phải trồng - rẽ phải - đi thẳng - rẽ trái.\n●Giao nhau cùng cấp có vòng xuyến: Chưa vào vòng xuyến thì ưu tiên xe bên phải, đã vào vòng xuyến ưu tiên xe từ bên trái tới.\n●Xe xuống dốc phải nhường đường cho xe đang lên dốc.");
        trickAdapter.notifyDataSetChanged();

    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_trick);
    }
    private void itemAdd( String tittle, String detail){
        tricks.add(new Trick(tittle,detail));
    }
}