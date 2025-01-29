package com.example.project2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.databinding.ItemLayoutBinding // Ensure this layout is created for displaying the photo
import com.example.project2.Model.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(private val photos: List<Photo>, private val onClick: (Photo) -> Unit) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = photos.size

    inner class PhotoViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            // Use Picasso to load the image from the download_url into the ImageView
            Picasso.get()
                .load(photo.download_url)  // Load the image URL from the Photo object
                .placeholder(android.R.drawable.ic_menu_gallery)  // Placeholder image while loading
                .error(android.R.drawable.ic_menu_report_image)  // Error image if the URL is invalid or loading fails
                .into(binding.photoImage)

            // Set an optional author name or any other field if needed
            // Assuming you have a TextView for the author in your layout
            // binding.authorText.text = photo.author  // Uncomment if you want to show the author's name

            // Set onClickListener to perform action when an item is clicked
            binding.root.setOnClickListener {
                onClick(photo)
            }
        }
    }
}
