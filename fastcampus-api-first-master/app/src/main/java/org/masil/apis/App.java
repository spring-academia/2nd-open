package org.masil.apis;

import org.slipp.masil.games.apis.ModelApiResponse;
import org.slipp.masil.games.apis.Pet;
import org.slipp.masil.games.apis.PetApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @RestController
    public static class PetController implements PetApi {

        @Override
        public ResponseEntity<Void> addPet(Pet body) {
            return null;
        }

        @Override
        public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
            return null;
        }

        @Override
        public ResponseEntity<List<Pet>> findPetsByStatus(List<String> status) {
            return null;
        }

        @Override
        public ResponseEntity<List<Pet>> findPetsByTags(List<String> tags) {
            return null;
        }

        @Override
        public ResponseEntity<Pet> getPetById(Long petId) {
            return ResponseEntity.ok(new Pet());
        }

        @Override
        public ResponseEntity<Void> updatePet(Pet body) {
            return null;
        }

        @Override
        public ResponseEntity<Void> updatePetWithForm(Long petId, String name, String status) {
            return null;
        }

        @Override
        public ResponseEntity<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, MultipartFile file) {
            return null;
        }
    }
}
