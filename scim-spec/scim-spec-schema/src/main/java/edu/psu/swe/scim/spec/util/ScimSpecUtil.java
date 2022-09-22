package edu.psu.swe.scim.spec.util;

import java.util.Collection;
import java.util.Optional;

import edu.psu.swe.scim.spec.resources.KeyedResource;
import edu.psu.swe.scim.spec.resources.TypedAttribute;

public class ScimSpecUtil {

  private ScimSpecUtil() {
    // private constructor for sonar
  }

  public static <T extends TypedAttribute> Optional<T> extractByType(Collection<T> collection, String type) {
    if (collection == null) {
      return Optional.empty();
    }
    return collection.stream()
                     .filter(t -> type.equalsIgnoreCase(t.getType()))
                     .findFirst();
  }

  public static <T extends KeyedResource> Optional<T> extractByKey(Collection<T> collection, String key) {
    if (collection == null) {
      return Optional.empty();
    }
    return collection.stream()
                     .filter(t -> key.equalsIgnoreCase(t.getKey()))
                     .findFirst();
  }
}
