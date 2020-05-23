package vn.edu.ntu.tuananh.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.ntu.tuananh.controller.ICartController;
import vn.edu.ntu.tuananh.model.Product;

public class ShoppingCartActivity extends AppCompatActivity {
    TextView txtCartInfo;
    Button btnSubmit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addViews();
        //addEvents();
    }
    private void addViews(){
        txtCartInfo = findViewById(R.id.txtCartInfo);
        btnSubmit = findViewById(R.id.btnThem);
        btnClear = findViewById(R.id.btnXoa);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ICartController cartController = (ICartController) getApplication();
                cartController.clearShoppingCart();
                txtCartInfo.setText("Giỏ hàng rỗng");
            }
        });
        ViewCartInfo();
    }

//    private void addEvents(){
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ICartController controller = (ICartController) ShoppingCartActivity.this.getApplication();
//                if(controller.getShoppingCart().size() > 0)
//                    confirm();
//                else
//                    Toast.makeText(ShoppingCartActivity.this, "Không có mặt hàng nào", Toast.LENGTH_SHORT).show();
//            }
//        });
//   }



    private void ViewCartInfo(){
        ICartController controller = (ICartController) ShoppingCartActivity.this.getApplication(); // lấy ra giỏ hàng
        ArrayList<Product> listProduct = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder(); //duyệt giơỏ hàng

        for(Product p: listProduct){
            builder.append(p.getName() + ": \t\t" + p.getPrice() + "vnd\n");
        }

        if(builder.toString().length() > 0)
                txtCartInfo.setText(builder.toString());
        else
            txtCartInfo.setText("Không có mạt hàng nào trong giỏ hàng");
    }



}
