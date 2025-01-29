package com.example.project2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.databinding.ItemLayoutBinding // Make sure to create this layout
import com.example.project2.Model.Post
import com.squareup.picasso.Picasso

class PostAdapter(private val posts: List<Post>, private val onClick: (Post) -> Unit) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = posts.size

    inner class PostViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            // Set the title and body text
            binding.titleText.text = post.title
            binding.bodyText.text = post.body

            // Use Picasso to load the image from the photoUrl into the ImageView
            Picasso.get()
                .load(post.photoUrl)  // Load the image URL from the Post object
                .placeholder(android.R.drawable.ic_menu_gallery)  // Placeholder image while loading
                .error(android.R.drawable.ic_menu_report_image)  // Error image if the URL is invalid or loading fails
                .into(binding.photoImage)

            // Set onClickListener to perform action when an item is clicked
            binding.root.setOnClickListener {
                onClick(post)
            }
        }
    }
}
