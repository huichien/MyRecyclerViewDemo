package android.example.myrecyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val studentList:List<Student>,private val listener:OnItemClickListener) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener{
        var tvId:TextView=view.findViewById(R.id.tvId)
        var tvName:TextView=view.findViewById(R.id.tvName)
        var tvProgramme:TextView=view.findViewById(R.id.tvProgramme)
        var imgPhoto:ImageView=view.findViewById(R.id.imgPhoto)

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(v:View?){
            val position=adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun itemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRec = studentList[position]

        holder.tvId.text = currentRec.id
        holder.tvName.text=currentRec.name
        holder.tvProgramme.text=currentRec.programme

        if(currentRec.gender=="F"){
            holder.imgPhoto.setImageResource(R.drawable.ic_female)
        } else{
                holder.imgPhoto.setImageResource(R.drawable.ic_male)
        }


    }

    override fun getItemCount(): Int {
        return studentList.size
    }

}