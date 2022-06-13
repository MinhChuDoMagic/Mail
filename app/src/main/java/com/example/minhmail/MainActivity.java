package com.example.minhmail;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mail> listMail;
    MailListViewAdapter productListViewAdapter;
    ListView listViewProduct;
    Integer[] listAvatar = {R.drawable.m, R.drawable.h, R.drawable.p};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khoi tao ListProduct
        listMail = new ArrayList<>();
        listMail.add(new Mail("Minh Chu", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus pulvinar accumsan accumsan. Vestibulum fringilla, metus ac commodo faucibus", "10:25 PM"));
        listMail.add(new Mail("Hùng Phạm", "Vestibulum lacinia lectus id ullamcorper fringilla. Suspendisse scelerisque ex arcu.", "9:10 PM"));
        listMail.add(new Mail("Phương Anh", "Nulla facilisi. Proin ultricies massa elit, eget blandit quam pretium id. Nam orci elit, suscipit at magna at, porta luctus lectus. In vulputate lacinia mattis", "8:40 PM"));

        productListViewAdapter = new MailListViewAdapter(listMail);
        listViewProduct = findViewById(R.id.listmail);
        listViewProduct.setAdapter(productListViewAdapter);

    }

    //Model phần tử dữ liệu hiện
    class Mail {
        ImageView image;
        String name;
        String content;
        String time;

        public Mail(String name, String content, String time) {
            this.name = name;
            this.content = content;
            this.time = time;
        }

    }

    class MailListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các sản phẩm
        final ArrayList<Mail> listMail;

        MailListViewAdapter(ArrayList<Mail> listMail) {
            this.listMail = listMail;
        }


        @Override
        public int getCount() {
            return listMail.size();
        }

        @Override
        public Object getItem(int position) {
            return listMail.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.mai_view, null);
            } else viewProduct = convertView;

            //Bind sữ liệu phần tử vào View
            Mail mail = (Mail) getItem(position);
            ((TextView) viewProduct.findViewById(R.id.name)).setText(mail.name);
            ((TextView) viewProduct.findViewById(R.id.content)).setText(mail.content);
            ((TextView) viewProduct.findViewById(R.id.time)).setText(mail.time);
            ((ImageView) viewProduct.findViewById(R.id.profile_image)).setImageResource(listAvatar[position]);


            return viewProduct;
        }
    }


}