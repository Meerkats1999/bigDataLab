#Insert
mongo --eval 'load("insert.js");' lab1

#Read
mongo --eval 'db.gameCollection.find().pretty();' lab1

#Find out the number of games which are having a rating between 8-9
mongo --eval 'db.gameCollection.find(
    {
    "rating":{$gte:8,$lte:9}
    }
).pretty();' lab1

#List out all the FPP games in the collections which is targeted audience are adults
mongo --eval 'db.gameCollection.find(
    {
    "targetAudience":{$in: ["Adults"]},
    "genre": "first-person shooter"
    }
).pretty();' lab1
#Update operation

mongo --eval 'db.gameCollection.update(
    {
        "name": "Fallout 76"},
        {$set:{"genre": "Massively multiplayer online role-playing game"}
        }
    )'
mongo --eval 'db.gameCollection.find(
    {"name":"Fallout 76"}
    ).pretty()' lab1

#Delete operation

mongo --eval 'db.gameCollection.deleteOne(
    {"name":"Fallout 76"}
   )' lab1

mongo --eval 'db.gameCollection.find(
    {"name":"Fallout 76"}
    ).pretty()' lab1
