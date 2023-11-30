package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.kawatrainingcenter.zanzibarnature.data.model.Location


@HiltViewModel
class ExploreListViewModel @Inject constructor() : ViewModel() {
    val locations = listOf(
        Location(
            id = 1,
            title = "Jozani-Chwaka Bay",
            description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar.\n" +
                    "\n" +
                    "The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",
            kawa = null,
            image = "https://lh5.googleusercontent.com/EPxKF-S8KuSb3YmyQSO1Fbk6Zm8VFYlwMNtpA-wNwl8YNilTYp7W2btwKY8QHBPbfnF75Nb7bBe3UPyl7HLIURmEDKEE3ZyLkgk_fWBoez6EvqLgY887uRYhlCPARiNa_urQ9-xJ",
            icons = listOf("hiking", "photo", "monkey"),
            location = "hier"
        ), Location(
            id = 2,
            title = "Nungwi Beach",
            description = "A very quiet beach on the outskirts of the island. Very beautiful place to enjoy the sunset.",
            kawa = "Help to keep the beaches clean!\n" +
                    "The Students from the Kawa Training Center often do beach clean-ups along this beach. If you want to support the Kawa Foundation in making Zanzibar a beautiful place again, feel free to contact us or make a donation.",
            icons = listOf("hiking", "photo", "swim"),
            image = "https://cdn-0.johnnyafrica.com/wp-content/uploads/2020/11/dsc00891.jpg",
            location = "hier"
        )
    )
}