package com.kawatrainingcenter.zanzibarnature.data.kawaApi.api

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationsEntity
import javax.inject.Inject

class mockData @Inject constructor() {
    fun getLocations(): LocationsEntity {
        return locations
    }
    fun getLocation(id: Int): LocationEntity {
       return locations.locations.filter { it.id == id }[0]
    }

    private val locations = LocationsEntity(listOf(
        LocationEntity(
            id = 1,
            title = "Jozani-Chwaka Bay",
            description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar. The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",
            kawa = "",
            images = listOf(
                "https://lh5.googleusercontent.com/EPxKF-S8KuSb3YmyQSO1Fbk6Zm8VFYlwMNtpA-wNwl8YNilTYp7W2btwKY8QHBPbfnF75Nb7bBe3UPyl7HLIURmEDKEE3ZyLkgk_fWBoez6EvqLgY887uRYhlCPARiNa_urQ9-xJ",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwildlifesafaritanzania.com%2Fwp-content%2Fuploads%2F2020%2F08%2FJozani-Chwaka-Bay-National-Park-Zanzibarss.jpg&f=1&nofb=1&ipt=7e9078ff98aad41d8ed8c6f5a129d8159d17cca342a1ec24b2d5c512a76aee41&ipo=images"
            ),
            icons = listOf("hiking", "photo", "monkey"),
            location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA"
        ),
        LocationEntity(
            id = 2,
            title = "Nungwi Beach",
            description = "A very quiet beach on the outskirts of the island. Very beautiful place to enjoy the sunset.",
            kawa = "Help to keep the beaches clean!. The Students from the Kawa Training Center often do beach clean-ups along this beach. If you want to support the Kawa Foundation in making Zanzibar a beautiful place again, feel free to contact us or make a donation.",
            images = listOf(
                "https://cdn-0.johnnyafrica.com/wp-content/uploads/2020/11/dsc00891.jpg",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fuploads-ssl.webflow.com%2F564479b70e1de1484e3e6973%2F5e0f1782a58dff16637ddc4a_8%2520Reasons%2520Why%2520Nungwi%2520Beach%2520Is%2520A%2520Top%2520Tourist%2520Destination.%2520The%2520Z%2520Hotel.jpg&f=1&nofb=1&ipt=90f88c6df8b6c006052cf31346b3d544866edbe2cb6c1f93c56f3ef9df0c055c&ipo=images",
                "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.beach-on-map.com%2Fimg%2F7%2Fzanzibar-island-nungwi-beach-rocks-orig.jpg&f=1&nofb=1&ipt=6d662dbbf298e4dad9e5a916a528b24656100dcf2f8623cab36d046099660f45&ipo=images"
            ),
            icons = listOf("hiking", "photo", "swim"),
            location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA"
        ),
        LocationEntity(
            id = 3,
            title = "Location 3",
            description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar. The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",            kawa = "",
            images = listOf(
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fres.cloudinary.com%2Fgrohealth%2Fimage%2Fupload%2Fv1583756529%2FDCUK%2FContent%2FiStock-577978980.jpg&f=1&nofb=1&ipt=a66fd4a0fc52465d7c95450e9a76b44a44afa274f6e1fd9bb4603aea0a8365ca&ipo=images",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.anansi.fr%2Fwp-content%2Fuploads%2F2020%2F04%2Fisland-4948796_1920.jpg&f=1&nofb=1&ipt=e92d5023e43dfb64504b9d8ee6470ceca756b9a0e6eb23e5d8342b0989780bfb&ipo=images"
            ),
            icons = listOf("hiking", "photo", "monkey"),
            location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA"
        ),
        LocationEntity(
            id = 4,
            title = "Location 4",
            description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar. The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",            kawa = "",
            images = listOf(
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fres.cloudinary.com%2Fgrohealth%2Fimage%2Fupload%2Fv1583756529%2FDCUK%2FContent%2FiStock-577978980.jpg&f=1&nofb=1&ipt=a66fd4a0fc52465d7c95450e9a76b44a44afa274f6e1fd9bb4603aea0a8365ca&ipo=images",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.anansi.fr%2Fwp-content%2Fuploads%2F2020%2F04%2Fisland-4948796_1920.jpg&f=1&nofb=1&ipt=e92d5023e43dfb64504b9d8ee6470ceca756b9a0e6eb23e5d8342b0989780bfb&ipo=images"
            ),
            icons = listOf("hiking", "photo", "monkey"),
            location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA"
        ),
        LocationEntity(
            id = 5,
            title = "Location 5",
            description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar. The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",            kawa = "",
            images = listOf(
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fres.cloudinary.com%2Fgrohealth%2Fimage%2Fupload%2Fv1583756529%2FDCUK%2FContent%2FiStock-577978980.jpg&f=1&nofb=1&ipt=a66fd4a0fc52465d7c95450e9a76b44a44afa274f6e1fd9bb4603aea0a8365ca&ipo=images",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.anansi.fr%2Fwp-content%2Fuploads%2F2020%2F04%2Fisland-4948796_1920.jpg&f=1&nofb=1&ipt=e92d5023e43dfb64504b9d8ee6470ceca756b9a0e6eb23e5d8342b0989780bfb&ipo=images"
            ),
            icons = listOf("hiking", "photo", "monkey"),
            location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA"
        ),
        LocationEntity(
            id = 6,
            title = "Location 6",
            description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar. The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",            kawa = "",
            images = listOf(
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fres.cloudinary.com%2Fgrohealth%2Fimage%2Fupload%2Fv1583756529%2FDCUK%2FContent%2FiStock-577978980.jpg&f=1&nofb=1&ipt=a66fd4a0fc52465d7c95450e9a76b44a44afa274f6e1fd9bb4603aea0a8365ca&ipo=images",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.anansi.fr%2Fwp-content%2Fuploads%2F2020%2F04%2Fisland-4948796_1920.jpg&f=1&nofb=1&ipt=e92d5023e43dfb64504b9d8ee6470ceca756b9a0e6eb23e5d8342b0989780bfb&ipo=images"
            ),
            icons = listOf("hiking", "photo", "monkey"),
            location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA"
        ),
    ))
}