/*
package com.kawatrainingcenter.zanzibarnature.data.kawaApi.api

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationsEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Projects
import javax.inject.Inject

class mockData @Inject constructor() {
    fun getLocations(): LocationsEntity {
        return locations
    }

    fun getLocation(id: Int): LocationEntity {
        return locations.locations.filter { it.id == id }[0]
    }

    fun getProjects(): Projects {
        return projects
    }

    fun getProject(name: String): Project {
        return projects.projects.filter { it.name == name }[0]
    }

    private val projects = Projects(
        listOf(
            Project(
                name = "The Kawa Foundation",
                description = "The Kawa Foundation aims to preserve cultural, environmental and historical heritage of Zanzibar.",
                image = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2F0eabQM5p0GA%2Fmaxresdefault.jpg&f=1&nofb=1&ipt=3e8d28fabb947f347cf6927e4184d600d2a00f0c50a1705c6a3ac74318a3736e&ipo=images"
            ),
            Project(
                name = "Tree Planting",
                description = "Protecting and restoring Zanzibar’s forests. Help us to create buffer zones and protect wild life.",
                image = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fforestsinternational.org%2Fwp-content%2Fuploads%2F2021%2F03%2FZanzibari-woman-planting-tree-seedling-768x512.jpg&f=1&nofb=1&ipt=447303feee43463e5f7f49a44e283eb963596ee674b521c0ed05a73b40a5781a&ipo=images"
            ),
            Project(
                name = "Outdoor Classroom",
                description = "URGENT: Donation needed for outdoor classroom.",
                image = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.pinimg.com%2Foriginals%2F87%2Fd4%2F47%2F87d4478a6d9bf7cad3f50694afaf40f6.png&f=1&nofb=1&ipt=b0e819fafc6dc063e80b4bd41661735375cb38b6e2a7e39a4193faaab53f6006&ipo=images"
            ),
            Project(
                name = "Beach Cleanup",
                description = "We organise a beach clean up every month with the students of the Kawa Training Center.",
                image = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.undp.org%2Fsites%2Fg%2Ffiles%2Fzskgke326%2Ffiles%2Fmigration%2Fgh%2FUNDP_Ghana_Beach_Clean_Up--1.jpg&f=1&nofb=1&ipt=3af44fb347becaa3f4c41803391cc561004bb8fd875fe82e86084c775d62469a&ipo=images"
            ),
        )
    )

    private val locations = LocationsEntity(
        listOf(
            LocationEntity(
                id = 1,
                title = "Jozani-Chwaka Bay",
                description = "The Jozani Chwaka Bay National Park is 50 km2 (19 sq mi). It is the only national park in Zanzibar. The Zanzibar red colobus is found in the park, a rain forest species (unlike the black-and-white colobus found in other regions of Africa) is only found in Zanzibar.",
                kawa = "",
                images = listOf(
                    "https://lh5.googleusercontent.com/EPxKF-S8KuSb3YmyQSO1Fbk6Zm8VFYlwMNtpA-wNwl8YNilTYp7W2btwKY8QHBPbfnF75Nb7bBe3UPyl7HLIURmEDKEE3ZyLkgk_fWBoez6EvqLgY887uRYhlCPARiNa_urQ9-xJ",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwildlifesafaritanzania.com%2Fwp-content%2Fuploads%2F2020%2F08%2FJozani-Chwaka-Bay-National-Park-Zanzibarss.jpg&f=1&nofb=1&ipt=7e9078ff98aad41d8ed8c6f5a129d8159d17cca342a1ec24b2d5c512a76aee41&ipo=images"
                ),
                icons = listOf("hiking", "photo", "wildlife"),
                location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA",
                coords = listOf(-6.272090950061236, 39.41971950258362)
            ),
            LocationEntity(
                id = 2,
                title = "Nungwi Beach",
                description = "A very quiet beach on the outskirts of the island. Very beautiful place to enjoy the sunset.",
                kawa = "Help to keep the beaches clean! The Students from the Kawa Training Center often do beach clean-ups along this beach. If you want to support the Kawa Foundation in making Zanzibar a beautiful place again, feel free to contact us or make a donation.",
                images = listOf(
                    "https://cdn-0.johnnyafrica.com/wp-content/uploads/2020/11/dsc00891.jpg",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fuploads-ssl.webflow.com%2F564479b70e1de1484e3e6973%2F5e0f1782a58dff16637ddc4a_8%2520Reasons%2520Why%2520Nungwi%2520Beach%2520Is%2520A%2520Top%2520Tourist%2520Destination.%2520The%2520Z%2520Hotel.jpg&f=1&nofb=1&ipt=90f88c6df8b6c006052cf31346b3d544866edbe2cb6c1f93c56f3ef9df0c055c&ipo=images",
                    "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.beach-on-map.com%2Fimg%2F7%2Fzanzibar-island-nungwi-beach-rocks-orig.jpg&f=1&nofb=1&ipt=6d662dbbf298e4dad9e5a916a528b24656100dcf2f8623cab36d046099660f45&ipo=images"
                ),
                icons = listOf("photo", "swimming", "project"),
                location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA",
                coords = listOf(-5.723657836087891, 39.29504563899864)
            ),
            LocationEntity(
                id = 3,
                title = "Kichwele Forest Reserve",
                description = "The reserve is an important biodiversity spot in the coral rag zone. The forest reserve is rich in both infaunal and floral species. ",
                kawa = "",
                images = listOf(
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fslevomat.sgcdn.cz%2Fimages%2Ft%2F640%2F10%2F36%2F10367290-a2e647.jpg&f=1&nofb=1&ipt=4d19da7bdd33b9ed3f3ed2eaaba603e5ba0b9f114555bcb07a363d00ef724238&ipo=images",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Flh3.googleusercontent.com%2Fp%2FAF1QipOk3bDfwErHrJuFnZKcnyOA35W0JqMeqQkjxp_7%3Ds1600-w400&f=1&nofb=1&ipt=af138ad7f5586690f7a6fcf2cc4b7b07b3e4809aab14c48df29c921c762dba2f&ipo=images",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fthumbs.dreamstime.com%2Fb%2Fjungle-forest-walking-path-wildlife-clear-sunny-day-island-zanzibar-tanzania-africa-east-179821577.jpg&f=1&nofb=1&ipt=5136f7286b1cc4f9369e4a86e6a3cc75114c625fc8cc1f58b6bfddf5cd543214&ipo=images"
                ),
                icons = listOf("hiking", "photo", "wildlife"),
                location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA",
                coords = listOf(-6.028056976123602, 39.290171461972236)
            ),
            LocationEntity(
                id = 4,
                title = "Masingini Forest",
                description = "Masingini Forest proves it. It’s a large forest close to the city, this allows you to reach it without making big trips. You can go on a nice hike among red monkeys and ancient trees. You can access it for free although, to explore the greater forest in a safe way, it is highly recommended to pay a full guided tour.",
                kawa = "",
                images = listOf(
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ffishermantours.com%2Fwp-content%2Fuploads%2F2021%2F06%2FMasingini-Tour.jpg&f=1&nofb=1&ipt=cd60aaf8e31f1af96065d262d2779a8402e501bac35bb87a27f0d72803b39ee5&ipo=images",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fsafarijunkie.com%2Fwp-content%2Fuploads%2F2016%2F04%2Fjozani-forest-tour-zanzibar-mangrove-boarwalk.jpg&f=1&nofb=1&ipt=337bed86f5c8edccc2d7fc9ee0e1f39b629256545af1b0b6dbfb93812ccb7260&ipo=images",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ffishermantours.com%2Fwp-content%2Fuploads%2F2022%2F02%2FJozani-Forest-Fisherman-Tours-1.png&f=1&nofb=1&ipt=66197cc99ce2777aae4478911991f346a9a4f4996e898257bfc9f6dafb08ac55&ipo=images"
                ),
                icons = listOf("hiking", "photo", "wildlife", "guided tour"),
                location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA",
                coords = listOf(-6.1144639504906415, 39.24245806205051)
            ),
            LocationEntity(
                id = 5,
                title = "Pongwe Beach",
                description = "The beach is one of the most beautiful on the island, soft white sand, fringed with coconut trees some with hammocks and plenty of space for everyone, at high tide the beach is cut off from the rest of the coast – why change perfection!",
                kawa = "",
                images = listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipP3pv-rnu3WiCR_3m8jJHqldY2JCvV8SVsLrBvZ=w513-h240-k-no",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fpix10.agoda.net%2FhotelImages%2F564%2F564664%2F564664_14092616380022436437.jpg%3Fs%3D1024x768&f=1&nofb=1&ipt=bc8511757be5290fef387b0c6897fcab60c7b8017464562d2b642176938ee658&ipo=images"
                ),
                icons = listOf("photo", "swimming"),
                location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA",
                coords = listOf(-6.050332487709873, 39.41048626088673)
            ),
            LocationEntity(
                id = 6,
                title = "Blue Bikes",
                description = "Discover the beauty of Zanzibar and step into the world of Bluebikes.\n" +
                        "\n" +
                        "Explore the island of Zanzibar by bike! Book one of our tours and enjoy the nature and culture.",
                kawa = "Our story began with the training of four promising graduate tour guide students. These very graduates started their career by setting up this social enterprise. Not only by running the daily operations, but also sharing their knowledge and expertise to the new Kawa students, teaching them bike mechanics and practicing their tour guiding skills.",
                images = listOf(
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F05%2Fe0%2F5f%2F34%2Fbike-zanzibar-private.jpg&f=1&nofb=1&ipt=761ab6f079148fcdbc5981b02c803ba77ed7a00c67cf4e0767ff8dc2833e1848&ipo=images",
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/e3/94/5c/mit-dem-boot-von-chwaka.jpg?w=1400&h=-1&s=1",
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic.wixstatic.com%2Fmedia%2Fd70bbf_f111c3a4d0f84a67ba47911fdf44a357.jpg&f=1&nofb=1&ipt=5c01a0983ba9e23968d799ba3ccb999c19077a576f8017cdbf9ad9d85a9ecdb3&ipo=images",
                ),
                icons = listOf("photo", "wildlife", "swimming", "guided tour", "project"),
                location = "https://maps.app.goo.gl/B7DJTMfQfGFunrdi9",
                coords = listOf(-6.160267050390132, 39.19354231688733)
            ),
        )
    )
}*/
