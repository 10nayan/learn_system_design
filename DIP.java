/*
The Dependency Inversion Principle (DIP) is one of the SOLID principles of object-oriented design. It states 
that high-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, 
abstractions should not depend on details. Details should depend on abstractions.

In the context of a movie recommendation system, we can have different recommendation engines that generate 
recommendations based on various criteria, such as user preferences, recently added movies, etc. 

In the first version of our recommendation engine (RecomendationEngineV1), we have a direct dependency on a 
specific implementation of the recommendation engine (GenreBasedRecomendationEngineV1). This violates the 
Dependency Inversion Principle because the high-level module (RecomendationEngineV1) is dependent on a low-level module (GenreBasedRecomendationEngineV1).

In the second version of our recommendation engine (RecomendationEngineV2), we introduce an abstraction 
(RecomendationEngine interface) that both the high-level module (RecomendationEngineV2) and the low-level modules
(GenreBasedRecomendationEngineV2 and RecentlyAddedRecomendationEngineV2) depend on. This way, we can easily swap out different implementations of the recommendation engine without affecting the high-level module, adhering to the Dependency Inversion Principle.
*/


class GenreBasedRecomendationEngineV1 {
    public void getRecomendations() {
        System.out.println("Generating recommendations based on user's preferred genres...");
    }
}

class RecentlyAddedRecomendationEngineV1 {
    public void getRecomendations() {
        System.out.println("Generating recommendations based on recently added movies...");
    }
}

class RecomendationEngineV1 {
    GenreBasedRecomendationEngineV1 recomender = new GenreBasedRecomendationEngineV1();
    public void recommend() {
        recomender.getRecomendations();
    }
}

interface RecomendationEngine {
    void getRecomendations();
}

class GenreBasedRecomendationEngineV2 implements RecomendationEngine {
    @Override
    public void getRecomendations() {
        System.out.println("Generating recommendations based on user's preferred genres...");
    }
}

class RecentlyAddedRecomendationEngineV2 implements RecomendationEngine {
    @Override
    public void getRecomendations() {
        System.out.println("Generating recommendations based on recently added movies...");
    }
}

class RecomendationEngineV2 {
    private RecomendationEngine recomender;

    public RecomendationEngineV2(RecomendationEngine recomender) {
        this.recomender = recomender;
    }

    public void recommend() {
        recomender.getRecomendations();
    }
}

public class DIP {
    public static void main(String[] args) {
        System.out.println("Dependency Inversion Principle (DIP) Example");
        RecomendationEngineV1 engine1 = new RecomendationEngineV1();
        engine1.recommend();
        RecomendationEngineV2 engineV2 = new RecomendationEngineV2(new GenreBasedRecomendationEngineV2());
        engineV2.recommend();
    }
}
