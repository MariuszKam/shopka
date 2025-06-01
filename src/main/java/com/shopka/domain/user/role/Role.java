package com.shopka.domain.user.role;

import java.util.Objects;

public class Role {

   private final RoleId id;

   public Role(RoleId id) {
    this.id = Objects.requireNonNull(id);
   }

   public RoleId getId() {
    return id;
   }

   @Override
   public int hashCode() {
    return Objects.hash(id);
   }

   @Override
   public boolean equals(Object obj) {
    return obj instanceof Role other && id.equals(other.id); 
   }
}
