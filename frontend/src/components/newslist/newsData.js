
const newsData = [
    // Your news data here
    {
        "Title":"Punjab Government offers jobs to 11 international players in PCS and PPS, CM hands over appointment letters",
        "Source":"punjabnewsexpress.com",
        "Url":"http://punjabnewsexpress.com/punjab/news/punjab-government-offers-jobs-to-11-international-players-in-pcs-and-pps-cm-hands-over-appointment-letters-238890",
        "Description":"<p><strong>CHANDIGARH</strong>: Punjab Chief Minister Bhagwant Singh Mann today handed over appointment letters for the posts of PCS and PPS to 11 players who had bagged the Bronze medal for the country in field of Hockey after a lull of 40 years and brought laurel in field of cricket and short put.</p>",
        "Image":"https://www.punjabnewsexpress.com/images/article/article238890.jpg"
    },
    {
        "Title":"California braces for 'bomb cyclone' as Pineapple Express is set to dump 8TRILLION gallons of rain - almost enough water to entirely fill Lake Mead",
        "Source":"dailymail.co.uk",
        "Url":"http://www.dailymail.co.uk/news/article-13043713/California-bomb-cyclone-Pineapple-Express-rain.html",
        "Description":"Atmospheric rivers began hitting the state last week, toppling trees and dousing roads. With the ground already soaked from the first storm, officials expressed concern about mudslides and flooding.",
        "Image":"https://i.dailymail.co.uk/1s/2024/02/04/14/80829679-0-image-m-11_1707057215621.jpg"
    },
    {
        "Title":"46 reported dead, 1,100 homes destroyed in Chile as forest fires move into densely populated central areas",
        "Source":"tribuneindia.com",
        "Url":"http://www.tribuneindia.com/news/world/46-reported-dead-1-100-homes-destroyed-in-chile-as-forest-fires-move-into-densely-populated-central-areas-587293",
        "Description":"Death toll could worsen as four large fires burn in the region of Valparaiso. Intense forest fires burning around a densely populated area of central Chile...",
        "Image":"https://englishtribuneimages.blob.core.windows.net/gallary-content/2024/2/2024_2$largeimg_226647870.webp"
    },
    {
        "Title": "शराब कारोबारी के ऊपर प्राणघातक हमला, पलटकर चलाई गोली तो हमलावर की मौत",
        "Description": "Neemach News: नीमच में शराब कारोबारी पर जानलेवा हमला हुआ। जिसमें वे बुरी तरह घायल हो गए। शराब कारोबारी की तरफ से भी जबावी फायरिंग की गई जिसमें एक हमलावर की मौत हो गई।",
        "Source": "haribhoomi.com",
        "Image": "https://images.naisadi.com/uploadimage/library/16_9/16_9_5/IMAGE_1707056436.webp",
        "Url": "http://www.haribhoomi.com/state-local/madhya-pradesh/news/open-firing-in-neemuch-fatal-attack-on-liquor-businessman-ashok-arora-fired-back-and-killed-attacker-8314"
    },
    {
        "Title": "लोकसभा की तैयारियों में जुटी बीजेपी : क्लस्टर बैठक के बाद किरण सिंहदेव बोले- घर-घर जाकर बतायेंगे मोदी जी की योजनाएं",
        "Description": "लोकसभा चुनाव को लेकर आज प्रदेश भाजपा कार्यालय में बीजेपी प्रदेश अध्यक्ष किरण सिंहदेव की अध्यक्षता में क्लस्टर बैठक की गई। बैठक में लोकसभा चुनाव की तैयारियां की गई।",
        "Source": "haribhoomi.com",
        "Image": "https://images.naisadi.com/uploadimage/library/16_9/16_9_5/IMAGE_1707055254.webp",
        "Url": "http://www.haribhoomi.com/state-local/chhattishgarh/news/bjp-busy-in-preparations-after-the-cluster-mee-iran-singhdev-said-ill-go-door-to-door-and-8309"
    },
    {
        "Title":"Federal Budget Required to Boost Gas Supply, Ease Living Costs",
        "Source":"miragenews.com",
        "Url":"https://www.miragenews.com/federal-budget-required-to-boost-gas-supply-1167184",
        "Description":"Victoria's extension of its Gas Substitution Roadmap will load more demand on to the state's fragile coal-based electricity system - risking blackouts",
        "Image":"https://energyproducers.au/wp-content/uploads/2021/07/Melbourne-Victoria-twt-1.jpeg"
    },
    {
        "Title": "International fake call centre busted in Delhi for duping US citizens",
        "Description": "<p><strong>NEW DELHI:</strong>&nbsp;Delhi Police on Sunday claimed to have busted an international fake call centre that was allegedly duping US nationals on the pretext of providing online support to foreign citizens by impersonating themselves as executives of top companies like Microsoft and Apple.</p>",
        "Source": "punjabnewsexpress.com",
        "Image": "https://www.punjabnewsexpress.com/images/article/article238889.jpg",
        "Url": "http://punjabnewsexpress.com/crime-justice/news/international-fake-call-centre-busted-in-delhi-for-duping-us-citizens-238889"
    },
    {
        "Title": "84 kg of ganja seized at Muthangi toll plaza",
        "Description": "84 kg ganja seized from an SUV while it was being taken to Maharashtra from the Andhra Pradesh border.",
        "Source": "telanganatoday.com",
        "Image": "https://cdn.telanganatoday.com/wp-content/uploads/2023/06/Ganja.jpg",
        "Url": "https://telanganatoday.com/84-kg-of-ganja-seized-at-muthangi-toll-plaza"
    },
    {
        "Title": "British Indian doctor to undertake ‘ground-breaking’ cancer vaccine trial",
        "Description": "A groundbreaking trial for a vaccine aimed at treating early-stage bowel cancer on a global scale is being led by a British Indian doctor serving as the chief investigator.",
        "Source": "telanganatoday.com",
        "Image": "https://cdn.telanganatoday.com/wp-content/uploads/2022/08/Indias-first-vaccine-against-cervical-cancer-to-come-on-September-1.jpg",
        "Url": "https://telanganatoday.com/british-indian-doctor-to-undertake-ground-breaking-cancer-vaccine-trial"
    },
    {
        "Title":"Support Telangana athletes, HCA chief urges government and corporates",
        "Source":"telanganatoday.com",
        "Url":"https://telanganatoday.com/support-telangana-athletes-hca-chief-urges-government-and-corporates",
        "Description":"There is a need to provide advanced training and financial encouragement to the sportspersons along with the development of the sports sector infrastructure in Telangana, said HCA chief",
        "Image":"https://cdn.telanganatoday.com/wp-content/uploads/2024/02/HCA.jpg"
    },
    {
        "Title":"Park Si Yeon concludes exclusive contract with L'Enter",
        "Source":"allkpop.com",
        "Url":"https://www.allkpop.com/article/2024/02/park-si-yeon-concludes-exclusive-contract-with-lenter",
        "Description":"Actress Park Si-yeon has gracefully concluded her exclusive contract with L'Enter, marking a beautiful end to their partnership. According to a repor…",
        "Image":"https://www.allkpop.com/upload/2024/02/content/040638/1707046739-0005012464-001-20240204164103921.jpg"
    },
    {
        "Title":"Indonesia Elections 2024: High stakes as presidential candidates face off in last TV debate",
        "Source":"channelnewsasia.com",
        "Url":"https://www.channelnewsasia.com/asia/indonesia-presidential-elections-anies-baswedan-prabowo-subianto-ganjar-pranowo-4098501",        
        "Description":"Five televised debates were held between December 12 and February 4, featuring presidential and vice-presidential candidates on various topics." ,
        "Image":"https://onecms-res.cloudinary.com/image/upload/s--TCOvPp7p--/c_crop,h_897,w_1595,x_5,y_2/fl_relative,g_south_east,l_mediacorp:cna:watermark:2021-08:cna,w_0.1/f_auto,q_auto/c_fill,g_auto,h_676,w_1200/v1/mediacorp/cna/image/2024/02/04/WhatsApp Image 2024-02-04 at 19.45.09.jpeg?itok=zc6Lyotc" 
    }

  ];
  
  export default newsData;
  