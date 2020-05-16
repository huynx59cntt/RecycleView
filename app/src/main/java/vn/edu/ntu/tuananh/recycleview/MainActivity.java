package vn.edu.ntu.tuananh.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.ntu.tuananh.controller.ICartController;
import vn.edu.ntu.tuananh.model.Product;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> listProduct;
    ProductAdapter adapter;
    RecyclerView rvListProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
    }
    private void addViews(){
        rvListProduct = findViewById(R.id.rvListProduct);
        rvListProduct.setLayoutManager(new LinearLayoutManager(this));
        ICartController controller = (ICartController) getApplication();
        listProduct = controller.getListProduct();
        adapter = new ProductAdapter(listProduct);
        rvListProduct.setAdapter(adapter);
    }
    private class ProductViewHoder extends RecyclerView.ViewHolder{
        TextView txtName, txtPrice, txtDesc;
        ImageView imBtnCart;
        public ProductViewHoder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDesc = this.itemView.findViewById(R.id.txtDesc);
            imBtnCart = this.itemView.findViewById(R.id.imBtnCart);
        }
        public void bind(Product p){
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString());
            txtDesc.setText(p.getDesc());
            imBtnCart.setImageResource(R.drawable.ic_action_add_to_cart);
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHoder>{
        ArrayList<Product> listProduct;

        public ProductAdapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }
        //tạo ra 1 view holder để hiển thị dữ liệu
        @NonNull
        @Override
        public ProductViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater= getLayoutInflater();
            //chuyển layout đã thiết kế bằng xml thành mộtđối tượng view
            View view = layoutInflater.inflate(R.layout.product_item,
                    parent, false);
            return new ProductViewHoder(view);
        }
        //kết nối một mục dữ liệu trong danh sách với một ViewHolder
        @Override
        public void onBindViewHolder(@NonNull ProductViewHoder holder, int position) {
            holder.bind(listProduct.get(position));
        }
        //trả về số lượng
        @Override
        public int getItemCount() {
            return listProduct.size();
        }
    }
}
