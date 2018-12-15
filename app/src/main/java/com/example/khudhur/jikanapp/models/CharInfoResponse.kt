package com.example.khudhur.jikanapp.models
import com.google.gson.annotations.SerializedName


 data  class CharInfoResponse (

    @SerializedName("mal_id")
    var malId: Int = 0, // 1
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/1/Spike_Spiegel
    @SerializedName("name")
    var name: String = "", // Spike Spiegel
    @SerializedName("name_kanji")
    var nameKanji: String = "", // スパイク・スピーゲル
    @SerializedName("nicknames")
    var nicknames: List<String> = listOf(),
    @SerializedName("about")
    var about: String = "", // Birthdate: June 26, 2044Height: 185 cm (6' 1")Weight: 70 kg (155 lbs)Blood type: OPlanet of Origin: MarsSpike Spiegel is a tall and lean 27-year-old bounty hunter born on Mars. The inspiration for Spike is found in martial artist Bruce Lee who uses the martial arts style of Jeet Kune Do as depicted in Session 8, "Waltz For Venus". He has fluffy, dark green hair (which is inspired by Yusaku Matsuda's) and reddish brown eyes, one of which is artificial and lighter than the other. He is usually dressed in a blue leisure suit, with a yellow shirt and Lupin III inspired boots. A flashback in Session 6 revealed it was his fully functioning right eye which was surgically replaced by the cybernetic one (although Spike himself may not have conscious recollection of the procedure since he claims to have lost his natural eye in an "accident"). One theory is that his natural eye may have been lost during the pre-series massacre in which he supposedly "died". The purpose of this cybernetic eye is never explicitly stated, though it apparently gives him exceptional hand-eye coordination - particularly with firearms (Spike's gun of choice is a Jericho 941, as seen throughout the series). In the first episode, when facing a bounty-head using Red Eye, Spike mocks him, calling his moves "too slow". At first, this seems like posturing on Spike's part, but even with his senses and reflexes accelerated to superhuman levels by the drug, the bounty cannot even touch Spike. A recurring device throughout the entire show is a closeup on Spike's fully-natural left eye before dissolving to a flashback of his life as part of the syndicate. As said by Spike himself in the last episode, his right eye "only sees the present" and his left eye "only sees the past." Spike often has a bent cigarette between his lips, sometimes despite rain or "No Smoking" signs.
    @SerializedName("member_favorites")
    var memberFavorites: Int = 0, // 25870
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/4/50197.jpg
    @SerializedName("animeography")
    var animeography: List<Animeography> = listOf(),
    @SerializedName("mangaography")
    var mangaography: List<Mangaography> = listOf(),
    @SerializedName("voice_actors")
    var voiceActors: List<VoiceActor> = listOf()
):BaseSearchResponse()

data class Animeography(
    @SerializedName("mal_id")
    var malId: Int = 0, // 4037
    @SerializedName("name")
    var name: String = "", // Cowboy Bebop: Yose Atsume Blues
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/anime/4037/Cowboy_Bebop__Yose_Atsume_Blues
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/anime/10/54341.jpg?s=ad2fb8157adfaa6c67008ef66200e004
    @SerializedName("role")
    var role: String = "" // Main
)

data class Mangaography(
    @SerializedName("mal_id")
    var malId: Int = 0, // 174
    @SerializedName("name")
    var name: String = "", // Shooting Star Bebop: Cowboy Bebop
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/manga/174/Shooting_Star_Bebop__Cowboy_Bebop
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/manga/3/176770.jpg?s=27a6072c91cf6e34e2388734c4089f56
    @SerializedName("role")
    var role: String = "" // Main
)

data class VoiceActor(
    @SerializedName("mal_id")
    var malId: Int = 0, // 25903
    @SerializedName("name")
    var name: String = "", // Mullenaerts, Bruno
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/people/25903/Bruno_Mullenaerts
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/questionmark_23.gif
    @SerializedName("language")
    var language: String = "" // French
)