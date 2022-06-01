                                                                                                                                                                            package com.example.yugenapp.models;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.yugenapp.R;
import com.example.yugenapp.animeselect;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaAnimeAdapter extends RecyclerView.Adapter<ListaAnimeAdapter.ViewHolder> {

    static ArrayList<datosApi> dataset;
    private LayoutInflater mInflater;
    private Context context;
    private ArrayList<datosApi> ListaPrincipal;

    private static List<datosApi> originalItems;

    public ListaAnimeAdapter(ArrayList<datosApi> listaResultado, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.dataset = listaResultado;

        ListaPrincipal = new ArrayList<>();
        ListaPrincipal.addAll(listaResultado);

        this.originalItems = new ArrayList<>();
        originalItems.addAll(dataset);
    }

    @NonNull
    @Override
    public ListaAnimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAnimeAdapter.ViewHolder holder, int position) {
        datosApi d = dataset.get(position);

        holder.textcard.setText(d.getTitle());

        String url = d.getImage_url();
        Glide.with(context)
                .load(url)
                .into(holder.imagencard);

        String title = d.getTitle();
        String sinopsis = d.getSynopsis();
        int epi = d.getEpisodes();
        String episodios = String.valueOf(epi);

        Double puntuacion = d.getScore();
        holder.puntos.setText(String.valueOf(puntuacion));

        String punt = String.valueOf(puntuacion);

        String tipo = d.getType();
        holder.tipo.setText(tipo);

        String rated = d.getRated();
        String link = d.getUrl();

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, animeselect.class);
                intent.putExtra("img", url);
                intent.putExtra("titulo", title);
                intent.putExtra("sinop", sinopsis);
                intent.putExtra("episode", episodios);
                intent.putExtra("punt", punt);
                intent.putExtra("tipo", tipo);
                intent.putExtra("rated", rated);
                intent.putExtra("link", link);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void filter(String search){
        if(search.length() == 0){
            dataset.clear();
            dataset.addAll(originalItems);
        }else{

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dataset.clear();
                List<datosApi> collect = originalItems.stream()
                        .filter(i -> i.getTitle().toLowerCase().contains(search))
                        .collect(Collectors.toList());
                dataset.addAll(collect);
            }
            else {
                dataset.clear();
                for(datosApi i : originalItems){
                    if (i.getTitle().toLowerCase().contains(search)){
                        dataset.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linear;
        private ImageView imagencard;
        private TextView textcard;
        private TextView puntos;
        private TextView tipo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textcard = itemView.findViewById(R.id.texto_portada);
            imagencard = itemView.findViewById(R.id.imagen_portada);
            linear = itemView.findViewById(R.id.Liner_Text);
            puntos = itemView.findViewById(R.id.punt);
            tipo = itemView.findViewById(R.id.typo);

        }
    }
}
