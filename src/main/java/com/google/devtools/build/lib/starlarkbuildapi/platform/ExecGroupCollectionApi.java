// Copyright 2020 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.starlarkbuildapi.platform;

import com.google.devtools.build.docgen.annot.DocCategory;
import net.starlark.java.annot.StarlarkBuiltin;
import net.starlark.java.annot.StarlarkMethod;
import net.starlark.java.eval.EvalException;
import net.starlark.java.eval.StarlarkIndexable;
import net.starlark.java.eval.StarlarkValue;

/** Stores exec groups available to a given rule. */
@StarlarkBuiltin(
    name = "ExecGroupCollection",
    category = DocCategory.BUILTIN,
    doc = "Stores exec groups available to a given rule.")
public interface ExecGroupCollectionApi extends StarlarkValue, StarlarkIndexable {

  /**
   * Stores information about a single exec group. The StarlarkMethod functions in this module
   * should be a subset of the StarlarkMethod functions available for the default exec group via
   * {@link StarlarkRuleContextApi}. This allows a user to pass in a rule ctx to the same places
   * that take an exec group ctx to have them operate on the default exec group.
   */
  @StarlarkBuiltin(
      name = "ExecGroupContext",
      category = DocCategory.BUILTIN,
      doc = "Stores information about an exec group.")
  interface ExecGroupContextApi extends StarlarkValue {
    @StarlarkMethod(
        name = "toolchains",
        structField = true,
        doc = "Toolchains required for this exec group")
    ToolchainContextApi toolchains() throws EvalException;
  }
}
