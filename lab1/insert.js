var gameInfoArray = [
    {
        name: "Dark Souls Prepare to Die Edition",
        genre: "Action role-playing game",
        developer: "From Software",
        targetAudience: [
            "Teens", 
            "Adults"
        ],
        rating: 9,
        comments: [
            "Punishingly brutal",
            "Tough but fair",
            "Breaking a rock with your flaccid penis"
        ]
    },
    {
        name: "Grand Theft Auto 5",
        genre: "Action adventure game",
        developer: "Rockstar North",
        targetAudience: [ 
            "Adults"
        ],
        rating: 9,
        comments: [
            "Incredible world",
            "Gripping story",
            "Varied, thrilling missions"
        ]
    },
    {
        name: "The Witcher 3: Wild Hunt",
        genre: "Action role-playing game",
        developer: "CD Projekt Red",
        targetAudience: [ 
            "Adults"
        ],
        rating: 10,
        comments: [
            "Massive world",
            "Great characters",
            "Deep roleplaying"
        ]
    },
    {
        name: "Fallout 76",
        genre: "Action role-playing game",
        developer: "Bethesda Game Studios",
        targetAudience: [
            "Teens", 
            "Adults"
        ],
        rating: 5,
        comments: [
            "Medicore",
            "Mess of Bugs",
            "Monotonous"
        ]
    },
    {
        name: "Metro: Exodus",
        genre: "first-person shooter",
        developer: "4A Games",
        targetAudience: [
            "Teens", 
            "Adults"
        ],
        rating: 8,
        comments: [
            "Awesome Gameplay",
            "A normal day in Russia"
        ]
    },
];

db.gameCollection.insert(gameInfoArray);
    