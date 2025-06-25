/*


// Java Design-1


You are building an E-Commerce Product Insights Engine for a marketplace like 
Amazon or Flipkart. The platform stores information about various products, 
their pricing history, and user ratings.

Your job is to:

    1. Accept data for multiple products.
    
    2. Each product has:
        Multiple price entries (date + price)
        Multiple ratings (user + stars out of 5)
        
    3. Calculate:
        Average price of the product
        Price volatility score: Standard deviation of prices
        Average rating

    4. Classify products into Insight Tiers:
        Stable & Loved: Volatility < 100 and Rating ≥ 4.0
        Unstable but Popular: Volatility ≥ 100 and Rating ≥ 4.0
        Unstable & Poorly Rated: Volatility ≥ 100 and Rating < 4.0
        table but Low-Rated: Volatility < 100 and Rating < 4.0
        
Sample Input:
-------------
2               // Number of products
EchoDot         // ProductName
3               // Number of price entries
2024-06-01 3499 // priceDate priceAmount
2024-06-10 3299
2024-06-15 3599
2               // Number of ratings
Alice 5         // userName stars
Bob 4
OldTV           // ProductName
4               // Number of price entries
2024-05-01 9999 // priceDate priceAmount
2024-05-10 10999
2024-05-15 11999
2024-05-20 8999
3               // Number of ratings
Charlie 2       // userName stars
Diana 3
Eve 1

Sample Output:
--------------
Product: EchoDot, AvgPrice: 3465.7, Volatility: 124.7, AvgRating: 4.5, Tier: Unstable but Popular
Product: OldTV, AvgPrice: 10499.0, Volatility: 1118.0, AvgRating: 2.0, Tier: Unstable & Poorly Rated

 */