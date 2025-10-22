package Controller;

import com.hexaware.bankmanagementsystem.model.Beneficiary;
import com.hexaware.bankmanagementsystem.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    // GET all beneficiaries
    @GetMapping
    public ResponseEntity<List<Beneficiary>> getAll() {
        return ResponseEntity.ok(beneficiaryService.getAll());
    }

    // GET com.hexaware.bankmangementsystem.beneficiary by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<Beneficiary> beneficiary = beneficiaryService.getById(id);

        return beneficiary.<ResponseEntity<Object>>map(b -> ResponseEntity.ok(b))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Beneficiary not found")));
    }

    // POST create new com.hexaware.bankmangementsystem.beneficiary
    @PostMapping
    public ResponseEntity<Beneficiary> create(@RequestBody Beneficiary model) {
        Beneficiary created = beneficiaryService.create(model);
        return ResponseEntity.ok(created);
    }

    // PUT - Update Beneficiary
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Beneficiary model) {
        Optional<Beneficiary> updated = beneficiaryService.update(id, model);

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Beneficiary not found"));
        }
    }

    // DELETE - Remove Beneficiary
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Beneficiary> existing = beneficiaryService.getById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Beneficiary not found"));
        }
        beneficiaryService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}