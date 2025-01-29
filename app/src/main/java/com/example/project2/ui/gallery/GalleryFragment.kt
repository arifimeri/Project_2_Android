    package com.example.project2.ui.gallery

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.fragment.app.Fragment
    import androidx.lifecycle.Observer
    import androidx.lifecycle.ViewModelProvider
    import com.example.project2.databinding.FragmentGalleryBinding

    class GalleryFragment : Fragment() {

        private lateinit var galleryViewModel: GalleryViewModel

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = FragmentGalleryBinding.inflate(inflater, container, false)

            // Initialize the ViewModel
            galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

            // Observe the photos LiveData
            galleryViewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
                // Update your UI with the list of photos, e.g., display in RecyclerView
            })

            // Add a photo (this could be triggered by a button or event)
            galleryViewModel.addPhoto("https://example.com/photo1.jpg")

            return binding.root
        }
    }
