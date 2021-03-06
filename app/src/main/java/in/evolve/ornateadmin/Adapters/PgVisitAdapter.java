package in.evolve.ornateadmin.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import in.evolve.ornateadmin.Models.PgRequest;
import in.evolve.ornateadmin.Models.PgVisitInfo;
import in.evolve.ornateadmin.R;

/**
 * Created by RAJEEV YADAV on 1/9/2017.
 */
public class PgVisitAdapter extends RecyclerView.Adapter<PgVisitAdapter.VisitorListViewHolder> {

    private Context context;
    private List<PgVisitInfo> list;
    public PgVisitAdapter(Context context, List<PgVisitInfo> list) {
        this.context=context;
        this.list=list;
    }
    @Override
    public VisitorListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VisitorListViewHolder(LayoutInflater.from(context).inflate(R.layout.pg_visit_custom_single_item,parent,false));
    }

    @Override
    public void onBindViewHolder(VisitorListViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());
        holder.phoneNumber.setText(list.get(position).getPhoneNumber());
        holder.occupancy.setText(list.get(position).getOccupancy());
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callUser(list.get(position).getPhoneNumber());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VisitorListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView email;
        TextView phoneNumber;
        TextView occupancy;
        TextView date;
        TextView time;
        ImageView call;

        public VisitorListViewHolder(View itemView) {
            super(itemView);
            call = (ImageView) itemView.findViewById(R.id.make_call);
            name= (TextView) itemView.findViewById(R.id.pg_visitor_name);
            email= (TextView) itemView.findViewById(R.id.pg_visitor_email);
            phoneNumber= (TextView) itemView.findViewById(R.id.pg_visitor_number);
            occupancy= (TextView) itemView.findViewById(R.id.pg_visitor_occupancy);
            date= (TextView) itemView.findViewById(R.id.pg_visitor_visit_date);
            time= (TextView) itemView.findViewById(R.id.pg_visitor_visit_time);
        }
    }

    public void changeList(List<PgVisitInfo> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    private void callUser(String phone){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }
}
