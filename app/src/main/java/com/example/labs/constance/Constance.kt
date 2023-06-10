package com.example.labs.constance

import java.net.URL

object Constance {
    val QUIZ_QUESTION_MAP : Map <Int, String> = mapOf(1 to "Москва - столица России?",
    2 to "Река Лена - самая длинная река в России?",
    3 to "Антарктическая пустыня является одной из самых маленьких пустынь?",
    4 to "Река Миссисипи протекает через 31 штат?",
    5 to "В Австралии 4 часовых пояса?",
    6 to "Нигерия имеет самое маленькое число населения?",
    7 to "Эльбрус - самая высокая гора в России",
    8 to "Полуостров Челюскин является самой северной точкой России?")
    val QUIZ_ANSWER_MAP : Map <Int, Boolean> = mapOf(1 to true,
        2 to true,
        3 to false,
        4 to true,
        5 to false,
        6 to false,
        7 to true,
        8 to true)
    val QUIZ_IMAGE_MAP : Map <Int, String> = mapOf(1 to "https://all-aforizmy.ru/wp-content/uploads/2022/03/31942208356_b7e7a8972c_o.jpg",
        2 to "https://webpulse.imgsmail.ru/imgpreview?key=pulse_cabinet-image-4468f918-8660-46c5-8d02-4b4ebb08e439&mb=webpulse",
        3 to "https://bogatyr.club/uploads/posts/2023-03/1678177474_bogatyr-club-p-arkticheskie-pustini-foni-vkontakte-72.jpg",
        4 to "http://1718494688.rsc.cdn77.org/wp-content/uploads/2018/11/expo-tvdc-253.jpg",
        5 to "https://pobedarf.ru/wp-content/uploads/2020/10/original_5a3ba5e6a24fd925a71927ec_5a729a5a5e458.jpg",
        6 to "https://cdn.nwmgroups.hu/s/img/i/1803/20180318legolcsobb-varosok-eiu2.jpg",
        7 to "https://sportishka.com/uploads/posts/2022-03/1648094096_42-sportishka-com-p-elbrus-i-kavkazskii-khrebet-turizm-krasivo-45.jpg",
        8 to "http://zapovedsever.ru/images/x/2yx-full.jpg")
}